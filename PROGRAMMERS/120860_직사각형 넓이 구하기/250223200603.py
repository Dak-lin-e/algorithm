# PROGRAMMERS #120860 · 직사각형 넓이 구하기
# https://school.programmers.co.kr/learn/courses/30/lessons/120860
# Language: python

def solution(dots):
    answer = []
    answer1 = []
    for i in range(4):
        answer.append(dots[i][0])
    for i in range(4):
        answer1.append(dots[i][1])
    
    return (max(answer)-min(answer))*(max(answer1)-min(answer1))
    