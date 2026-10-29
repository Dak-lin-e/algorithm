# PROGRAMMERS #12906 · 같은 숫자는 싫어
# https://school.programmers.co.kr/learn/courses/30/lessons/12906
# Language: python

from collections import deque
def solution(arr):
    answer=[]
    answer.append(arr[0])
    for i in arr:
        if i == answer[-1]:
            answer.pop()
            answer.append(i)
        else:
            answer.append(i)
            
    return answer