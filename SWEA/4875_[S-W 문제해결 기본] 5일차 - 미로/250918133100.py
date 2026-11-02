# SWEA #4875 · [S/W 문제해결 기본] 5일차 - 미로
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQeET6QlADFAVT
# Language: Python
# Execution Time: 127 ms
# Memory: 64640 KB

def dfs(x, y, N, maze):
    # 맵의 범위를 벗어나거나 벽(1)에 부딪히면 종료
    if not (0 <= x < N and 0 <= y < N) or maze[x][y] == 1:
        return 0

    # 목적지(3)에 도달하면 성공
    if maze[x][y] == 3:
        return 1

    # 이미 방문한 곳(9)은 다시 가지 않음
    if maze[x][y] == 9:
        return 0

    # 현재 위치를 '방문함'으로 표시
    maze[x][y] = 9

    # 상하좌우 방향
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # 네 방향으로 재귀 호출
    for i in range(4):
        new_x = x + dx[i]
        new_y = y + dy[i]
        if dfs(new_x, new_y, N, maze) == 1:
            return 1

    return 0

def solve_maze():
    N = int(input())
    maze = []
    for _ in range(N):
        # 공백 없이 붙어있는 숫자를 읽어오는 방법
        line = input()
        maze.append(list(map(int, list(line))))

    # 시작점(2) 찾기
    start_x, start_y = -1, -1
    for i in range(N):
        for j in range(N):
            if maze[i][j] == 2:
                start_x, start_y = i, j
                break
        if start_x != -1:
            break

    if start_x == -1:
        return 0 # 시작점이 없는 경우

    return dfs(start_x, start_y, N, maze)

T = int(input())
for t in range(1, T + 1):
    try:
        result = solve_maze()
        print(f'#{t} {result}')
    except Exception as e:
        print(f'#{t} error')