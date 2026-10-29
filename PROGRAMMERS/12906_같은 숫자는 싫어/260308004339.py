# PROGRAMMERS #12906 · 같은 숫자는 싫어
# https://school.programmers.co.kr/learn/courses/30/lessons/12906
# Language: python

from collections import deque
def solution(arr):
    answer=[arr[0]]
    for i in arr:
        j = answer[-1]
        if i ==j:
            pass
        else:
            answer.append(i)
    
            
    return answer
