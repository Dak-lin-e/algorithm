# PROGRAMMERS #120844 · 배열 회전시키기
# https://school.programmers.co.kr/learn/courses/30/lessons/120844
# Language: python

def solution(numbers, direction):
    answer =[0]*len(numbers)
    if direction == 'right':
        for i in range(len(numbers)):
            answer[i-len(numbers)+1]=numbers[i]
    elif direction == 'left':
        for i in range(len(numbers)):
            answer[i-1]=numbers[i]
    else:
        pass
            
    return answer