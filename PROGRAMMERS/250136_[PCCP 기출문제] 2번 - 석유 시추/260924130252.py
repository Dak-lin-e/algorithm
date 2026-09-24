# PROGRAMMERS #250136 · [PCCP 기출문제] 2번 / 석유 시추
# https://school.programmers.co.kr/learn/courses/30/lessons/250136
# Language: Python

from collections import deque

def solution(land):
    n, m = len(land), len(land[0])  # n: 세로 크기, m: 가로 크기
    visited = [[False] * m for _ in range(n)]  # 방문 여부 저장
    oil_groups = []  # 각 석유 덩어리의 크기 및 포함된 열 저장
    column_oil = [set() for _ in range(m)]  # 각 열에 포함된 석유 덩어리 인덱스 저장

    # BFS를 사용하여 석유 덩어리 찾기
    def bfs(start_x, start_y, group_id):
        queue = deque([(start_x, start_y)])
        visited[start_x][start_y] = True
        oil_size = 0  # 현재 석유 덩어리 크기
        columns = set()  # 해당 석유 덩어리가 포함된 열

        while queue:
            x, y = queue.popleft()
            oil_size += 1
            columns.add(y)

            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:  # 상하좌우 이동
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and land[nx][ny] == 1:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

        # 저장
        oil_groups.append(oil_size)  # 석유 덩어리 크기 저장
        for col in columns:
            column_oil[col].add(group_id)  # 각 열에 속한 석유 덩어리 ID 저장

    # 모든 석유 덩어리 탐색
    group_id = 0  # 석유 덩어리 ID
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                bfs(i, j, group_id)
                group_id += 1  # 새로운 덩어리 ID 증가

    # 시추관을 설치했을 때 최대 석유량 찾기
    max_oil = 0
    for col in range(m):  # 각 열마다 확인
        total_oil = sum(oil_groups[gid] for gid in column_oil[col])  # 해당 열에 포함된 석유 덩어리 합산
        max_oil = max(max_oil, total_oil)  # 최대값 갱신

    return max_oil
