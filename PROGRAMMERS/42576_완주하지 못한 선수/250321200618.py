# PROGRAMMERS #42576 · 완주하지 못한 선수
# https://school.programmers.co.kr/learn/courses/30/lessons/42576
# Language: python

from collections import Counter

def solution(participant, completion):
    # 참가자 목록을 Counter로 저장
    participant_counter = Counter(participant)
    
    # 완주자 목록을 빼기 연산하여 남은 사람 찾기
    for player in completion:
        participant_counter[player] -= 1
    
    # 남아있는 선수 찾기 (값이 1인 선수 반환)
    for player, count in participant_counter.items():
        if count > 0:
            return player
