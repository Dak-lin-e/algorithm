# PROGRAMMERS #120923 · 연속된 수의 합
# https://school.programmers.co.kr/learn/courses/30/lessons/120923
# Language: python

def solution(n, total):
    answer=[]
    a=(total - (n*(n-1)) / 2)/n  
    for i in range(n):
        answer.append(a+i)
    return answer