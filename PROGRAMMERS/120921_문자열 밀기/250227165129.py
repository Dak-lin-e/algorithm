# PROGRAMMERS #120921 · 문자열 밀기
# https://school.programmers.co.kr/learn/courses/30/lessons/120921
# Language: python

def solution(A, B):
    answer = -1
    a=[]
    if A==B:
        return 0
    
    for i in range(len(A)-1,0,-1):
        a.append(A[i:]+ A[:i])
    
    for i,j in enumerate(a):
        if j == B:
            return i+1
            
    return answer