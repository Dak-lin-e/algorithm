# PROGRAMMERS #42576 · 완주하지 못한 선수
# https://school.programmers.co.kr/learn/courses/30/lessons/42576
# Language: python

from collections import Counter

def solution(participant, completion): 
    participant1=Counter(participant)
    for i in completion:
        participant1[i] = participant1[i]-1
    answer=participant1.most_common(1)
    return answer[0][0]