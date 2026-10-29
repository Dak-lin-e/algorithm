# PROGRAMMERS #120871 · 저주의 숫자 3
# https://school.programmers.co.kr/learn/courses/30/lessons/120871
# Language: python


def solution(n):
    answer = 0
    a = list(range(1, 300))  # 1부터 n까지의 리스트 생성
    a = [i for i in a if '3' not in str(i) and  i % 3 != 0]  # '3'이 포함된 숫자 제거
    
    b= list(range(1,n+1))

    for i,j in enumerate(b):
          if j == n:
            answer = a[i]

    return answer

