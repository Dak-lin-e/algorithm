# PROGRAMMERS #120891 · 369게임
# https://school.programmers.co.kr/learn/courses/30/lessons/120891
# Language: python

def solution(order):
    answer = 0
    for i in str(order):
        if i == '3' :
            answer = answer+1
        elif i =='6':
            answer = answer+1

        elif i=='9':
            answer = answer+1
        else :
            pass
    return answer