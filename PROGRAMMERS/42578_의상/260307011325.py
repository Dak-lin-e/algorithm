# PROGRAMMERS #42578 · 의상
# https://school.programmers.co.kr/learn/courses/30/lessons/42578
# Language: python

def solution(clothes):
    data = {}
    
    # 작성하신 완벽한 해시(딕셔너리) 분류 로직! (그대로 유지)
    for i in clothes:
        if i[1] in data:
            data[i[1]] += 1
        else:
            data[i[1]] = 1
            
    # 곱셈을 해야 하므로 초기값을 1로 설정합니다.
    answer = 1 
    
    # 각 종류별 옷의 개수에 '안 입는 경우(+1)'를 더해서 전부 곱해줍니다.
    for j in data:
        answer *= (data[j] + 1)
        
    # 마지막으로 모든 옷을 '안 입음'으로 선택한 경우(알몸) 1가지를 빼줍니다.
    return answer - 1