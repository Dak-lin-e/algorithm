# SWEA #4881 · [S/W 문제해결 기본] 5일차 - 배열 최소 합
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQh00qQs0DFAVT
# Language: Python
# Execution Time: 108 ms
# Memory: 60544 KB

def find_min_sum(row, current_sum, n, grid, visited_cols):
    """
    백트래킹을 사용하여 최소 합을 찾는 재귀 함수
    """
    global min_sum
    
    # 가지치기: 현재 합이 이미 최소 합보다 크거나 같으면 탐색 중단
    if current_sum >= min_sum:
        return
    
    # 기저 조건: 모든 행을 다 탐색했을 경우
    if row == n:
        min_sum = current_sum
        return
    
    # 현재 행(row)에서 열(col)을 순회하며 숫자 선택
    for col in range(n):
        if not visited_cols[col]:
            visited_cols[col] = True  # 현재 열 방문 표시
            find_min_sum(row + 1, current_sum + grid[row][col], n, grid, visited_cols)
            visited_cols[col] = False # 백트래킹: 다음 탐색을 위해 방문 표시 해제

def solve():
    global min_sum
    n = int(input())
    grid = [list(map(int, input().split())) for _ in range(n)]
    
    # 전역 변수 초기화
    min_sum = float('inf')
    visited_cols = [False] * n
    
    # 백트래킹 시작 (0번째 행, 합계 0부터)
    find_min_sum(0, 0, n, grid, visited_cols)
    
    return min_sum

# 메인 실행 부분
T = int(input())
for t in range(1, T + 1):
    result = solve()
    print(f'#{t} {result}')