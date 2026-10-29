# PROGRAMMERS #42840 · 모의고사
# https://school.programmers.co.kr/learn/courses/30/lessons/42840
# Language: python

def solution(answers):
    answer1 = []
    an1=[1,2,3,4,5]
    an2=[2,1,2,3,2,4,2,5]
    an3=[3,3,1,1,2,2,4,4,5,5]
    answer=[0,0,0]
    for idx,m in enumerate(answers):
        if m == an1[idx%len(an1)]:
            answer[0]+=1
        if m == an2[idx%len(an2)]:
            answer[1]+=1
        if m==an3[idx%len(an3)]:
            answer[2]+=1
    max1 = max(answer)
    for i,j in enumerate(answer):
        if j == max1:
            answer1.append(i+1)
        
    
    return answer1