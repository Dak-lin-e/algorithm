# PROGRAMMERS #181832 · 정수를 나선형으로 배치하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181832
# Language: python

def solution(n):
    matrix = [[0] * n for _ in range(n)]
    num = 1
    left, right, top, bottom = 0, n - 1, 0, n - 1
    
    while num <= n * n:
        # 왼쪽 → 오른쪽
        for i in range(left, right + 1):
            matrix[top][i] = num
            num += 1
        top += 1
        
        # 위 → 아래
        for i in range(top, bottom + 1):
            matrix[i][right] = num
            num += 1
        right -= 1
        
        # 오른쪽 → 왼쪽
        for i in range(right, left - 1, -1):
            matrix[bottom][i] = num
            num += 1
        bottom -= 1
        
        # 아래 → 위
        for i in range(bottom, top - 1, -1):
            matrix[i][left] = num
            num += 1
        left += 1
        
    return matrix