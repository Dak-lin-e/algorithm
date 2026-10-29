# PROGRAMMERS #42746 · 가장 큰 수
# https://school.programmers.co.kr/learn/courses/30/lessons/42746
# Language: python

def solution(numbers):
    # 1. 모든 숫자를 문자열로 변환합니다.
    numbers = list(map(str, numbers))
    
    # 2. 핵심: 문자열을 3번 반복한 값을 기준으로 내림차순(reverse=True) 정렬합니다.
    # 원소가 최대 3자리(1000 미만)이므로, 3배를 채워주면 글자 비교 시 자릿수 불이익이 사라집니다.
    numbers.sort(key=lambda x: x * 3, reverse=True)
    
    # 3. 정렬된 문자열을 하나로 이어 붙입니다.
    answer = ''.join(numbers)
    
    # 4. 예외 처리: [0, 0, 0]이 들어왔을 때 "000"이 아니라 "0"이 출력되도록 합니다.
    # 첫 글자가 '0'이라는 것은 뒤의 숫자들도 전부 '0'이거나 더 작다는 뜻이므로 그냥 "0"을 리턴합니다.
    if answer[0] == '0':
        return '0'
        
    return answer