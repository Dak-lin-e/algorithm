# PROGRAMMERS #120882 · 등수 매기기
# https://school.programmers.co.kr/learn/courses/30/lessons/120882
# Language: python

def solution(score):
    answer=[]
    an=[]
    for i in score:
        answer.append(sum(i))
        an.append(sum(i))
        
    answer.sort(reverse=True)
    
    for i,j in enumerate(an):
        for k,m in enumerate(answer):
            if j == m:
                an[i]=answer.index(m)+1
            else: 
                pass
    
    
    return an