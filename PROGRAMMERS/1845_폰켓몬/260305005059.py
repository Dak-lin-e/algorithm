# PROGRAMMERS #1845 · 폰켓몬
# https://school.programmers.co.kr/learn/courses/30/lessons/1845
# Language: python

from collections import Counter

def solution(nums):

    num = len(nums) / 2
    data = Counter(nums)
    if len(data) >= num:
        return num
    else :
        return len(data)
    