# PROGRAMMERS #181833 · 특별한 이차원 배열 1
# https://school.programmers.co.kr/learn/courses/30/lessons/181833
# Language: python

answer=[]
def solution(n):
    for i in range(n):
      an=[]
      for j in range(n):
        if i==j :
          an.append(1)
        elif i!=j :
          an.append(0)
        else:
          pass
            
      answer.append(an)
      
    return answer