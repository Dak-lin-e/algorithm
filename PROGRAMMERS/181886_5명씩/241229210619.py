# PROGRAMMERS #181886 · 5명씩
# https://school.programmers.co.kr/learn/courses/30/lessons/181886
# Language: python

def solution(names):
    answer = []
    
    for i in range(len(names)):
        if i%5==0:
            answer.append(names[i])
        else:
            pass
        
    return answer