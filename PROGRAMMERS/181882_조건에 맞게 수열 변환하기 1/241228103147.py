# PROGRAMMERS #181882 · 조건에 맞게 수열 변환하기 1
# https://school.programmers.co.kr/learn/courses/30/lessons/181882
# Language: python

def solution(arr):
    answer = []
    for i in arr :
        if i >=50 and i%2 ==0:
            answer.append(i/2)
        elif i < 50 and i%2 !=0:
            answer.append(i*2)
        else: 
            answer.append(i)
    return answer