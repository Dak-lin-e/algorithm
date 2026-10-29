# PROGRAMMERS #181837 · 커피 심부름
# https://school.programmers.co.kr/learn/courses/30/lessons/181837
# Language: python

def solution(order):
    answer = 0
    for item in order:
        if item == "anything" : 
            answer += 4500
        elif item == 'americano':
            answer += 4500
        elif item == 'americanoice':
            answer += 4500
        elif item == 'iceamericano':
            answer += 4500
        elif item == 'hotamericano':
            answer += 4500
        elif item == 'americanohot':
            answer += 4500
        else:
            answer += 5000
    return answer