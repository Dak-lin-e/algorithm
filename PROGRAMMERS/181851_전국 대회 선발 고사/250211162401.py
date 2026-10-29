# PROGRAMMERS #181851 · 전국 대회 선발 고사
# https://school.programmers.co.kr/learn/courses/30/lessons/181851
# Language: python

def solution(rank, attendance):
    result=[]
    for i in range(len(rank)):
        if attendance[i]==True :
            result.append(rank[i])
    result.sort()
    
    return 10000*rank.index(result[0])+100*rank.index(result[1])+rank.index(result[2])