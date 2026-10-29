# PROGRAMMERS #178871 · 달리기 경주
# https://school.programmers.co.kr/learn/courses/30/lessons/178871
# Language: python

def solution(players, callings):
    answer = {}
    for i,j in enumerate(players):
        answer[j]=i
    for j in callings:
        index1=answer[j]
        player=players[index1-1]
        players[index1],players[index1-1]=players[index1-1],players[index1]
        
        answer[j]=index1-1
        answer[player]=index1
        answer
    return players