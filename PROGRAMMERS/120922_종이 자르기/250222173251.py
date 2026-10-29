# PROGRAMMERS #120922 · 종이 자르기
# https://school.programmers.co.kr/learn/courses/30/lessons/120922
# Language: python

def solution(M, N):
    answer = 0
    answer= answer+(M-1)
    answer=answer + (N-1)*(M)
    return answer