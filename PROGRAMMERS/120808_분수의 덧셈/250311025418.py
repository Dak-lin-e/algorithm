# PROGRAMMERS #120808 · 분수의 덧셈
# https://school.programmers.co.kr/learn/courses/30/lessons/120808
# Language: python

import math

def solution(numer1, denom1, numer2, denom2):
    # 공통 분모(두 분모의 최소공배수 구하기)
    lcm = (denom1 * denom2) // math.gcd(denom1, denom2)
    
    # 분자 변환 및 합산
    new_numer = (numer1 * (lcm // denom1)) + (numer2 * (lcm // denom2))
    
    # 기약 분수로 만들기 위해 최대공약수 구하기
    gcd = math.gcd(new_numer, lcm)
    
    # 기약 분수로 변환
    return [new_numer // gcd, lcm // gcd]

