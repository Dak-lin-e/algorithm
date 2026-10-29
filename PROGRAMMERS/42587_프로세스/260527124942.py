# PROGRAMMERS #42587 · 프로세스
# https://school.programmers.co.kr/learn/courses/30/lessons/42587
# Language: python

from collections import deque

def solution(priorities, location):
    answer1={}
    pre=deque(priorities)
    pre1=deque([i for i in range(len(priorities))])
    while len(pre)!=1:
        i=pre.popleft()
        m=pre1.popleft()
        if max(pre) > i:
            pre.append(i)
            pre1.append(m)
        else:
            answer1[m]=i
            
    i=pre.popleft()
    m=pre1.popleft()
    answer1[m]=i
    answer=0
    for j,k in answer1.items():
        if j==location:
            return (answer+1)
        else:
            answer+=1
    
    