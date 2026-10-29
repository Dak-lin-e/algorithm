# PROGRAMMERS #181856 · 배열 비교하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181856
# Language: python

def solution(arr1, arr2):
    if len(arr1) > len(arr2):
        answer = 1
    elif len(arr2) > len(arr1):
        answer = -1
    elif len(arr1) == len(arr2):
        if sum(arr1) > sum(arr2):
            answer = 1
        elif sum(arr2) > sum(arr1):
            answer = -1
        else : 
            answer = 0
    else:
        answer =0
    return answer