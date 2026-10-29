# PROGRAMMERS #120815 · 피자 나눠 먹기 (2)
# https://school.programmers.co.kr/learn/courses/30/lessons/120815
# Language: python

def solution(n):
    i=1
    while True:
        p = n * i
        if p % 6==0:
            break
        i+=1
    k = p / 6

    return k