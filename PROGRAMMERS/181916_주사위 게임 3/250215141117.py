# PROGRAMMERS #181916 · 주사위 게임 3
# https://school.programmers.co.kr/learn/courses/30/lessons/181916
# Language: python

def solution(a, b, c, d):
    m=[a,b,c,d]
    n=[]
    p=[]
    for i in m:
        if i not in n:
            n.append(i)
        else :
            p.append(i)
            
    if len(n) == 1:
        answer = 1111 * a
    elif len(n) == 4:
        answer = min(n)
    elif len(n) == 3:
        if p[0]==n[0]:
            answer = n[1] * n[2] 
        elif p[0]==n[1]:
            answer = n[0] * n[2]
        elif p[0]==n[2]:
            answer = n[0] * n[1]
        else :
            pass
    
    elif len(p) == 2:
        if p[0] == p[1]:
            if p[0] !=n[0]:
                answer = (10 * p[0]+n[0])**2
            elif p[0] ==n[0]:
                answer = (10 * p[0]+n[1])**2
            else:
                pass
            
        elif p[0] != p[1]:
            answer = (p[0]+p[1]) * abs(p[0]-p[1])
        else : 
            pass
    else :
        pass
        

    
    return answer