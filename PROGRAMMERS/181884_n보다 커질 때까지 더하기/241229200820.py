# PROGRAMMERS #181884 · n보다 커질 때까지 더하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181884
# Language: python

def solution(numbers, n):
    answer = 0
    for i in numbers:
        answer = i+answer
        if answer>n:
            break
    return answer