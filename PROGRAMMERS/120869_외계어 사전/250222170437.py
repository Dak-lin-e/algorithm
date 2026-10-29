# PROGRAMMERS #120869 · 외계어 사전
# https://school.programmers.co.kr/learn/courses/30/lessons/120869
# Language: python

def solution(spell, dic):
    spell_set = set(spell)  # spell의 알파벳을 집합으로 변환
    
    for word in dic:
        if set(word) == spell_set:  # 단어의 문자 집합이 spell과 동일한지 확인
            return 1
    
    return 2