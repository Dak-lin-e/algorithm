# PROGRAMMERS #43165 · 타겟 넘버
# https://school.programmers.co.kr/learn/courses/30/lessons/43165
# Language: python

def solution(numbers, target):
    answer = 0

    def dfs(idx, total):
        nonlocal answer
        # 모든 숫자를 사용한 경우 target과 비교
        if idx == len(numbers):
            if total == target:
                answer += 1
            return
        # 해당 숫자를 더하는 경우와 빼는 경우를 모두 재귀 호출
        dfs(idx + 1, total + numbers[idx])
        dfs(idx + 1, total - numbers[idx])
    
    dfs(0, 0)
    return answer
