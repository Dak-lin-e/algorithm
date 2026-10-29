# PROGRAMMERS #181891 · 순서 바꾸기
# https://school.programmers.co.kr/learn/courses/30/lessons/181891
# Language: python

def solution(num_list, n):
    a=num_list[:n:]
    b=num_list[n::]
    return b+a