# PROGRAMMERS #43165 · 타겟 넘버
# https://school.programmers.co.kr/learn/courses/30/lessons/43165
# Language: python

def solution(numbers, target):
    answer = 0
    def dfs(idx,total):
        nonlocal answer
        
        if idx == len(numbers):
            if total == target:
                answer+=1
            return
            
        dfs(idx+1, total + numbers[idx])
        dfs(idx+1, total - numbers[idx])
        
    dfs(0,0)
    return answer
