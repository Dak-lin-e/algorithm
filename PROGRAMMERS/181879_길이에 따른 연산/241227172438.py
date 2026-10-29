# PROGRAMMERS #181879 · 길이에 따른 연산
# https://school.programmers.co.kr/learn/courses/30/lessons/181879
# Language: python

from functools import reduce
def solution(num_list):
    result=0
    if len(num_list) >=11 :
        result=sum(num_list)
    else:
        result=reduce(lambda x, y: x * y, num_list)
    return result