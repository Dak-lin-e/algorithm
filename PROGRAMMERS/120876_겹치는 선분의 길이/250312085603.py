# PROGRAMMERS #120876 · 겹치는 선분의 길이
# https://school.programmers.co.kr/learn/courses/30/lessons/120876
# Language: python

def solution(lines):
    a=set()
    b=set()
    c=set()
    d=set()
    e=set()
    f=set()
    g=set()
    
    
    for i in range(lines[0][0],lines[0][1]):
        a.add(i)
    for i in range(lines[1][0],lines[1][1]):
        b.add(i)
    for i in range(lines[2][0],lines[2][1]):
        c.add(i)
        
    d=a&b
    e=c&b
    f=a&c
    
    g=d|e|f
    
    return len(g)