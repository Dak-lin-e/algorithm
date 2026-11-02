# SWEA #5102 · [S/W 문제해결 기본] 6일차 - 노드의 거리
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTVmxDKb1oDFAVT
# Language: Python
# Execution Time: 73 ms
# Memory: 54144 KB

from collections import deque

def bfs(graph, start, end):
    """
    BFS를 이용하여 시작 노드에서 도착 노드까지의 최단 거리를 찾는 함수
    """
    if start == end:
        return 0

    queue = deque([(start, 0)])  # (노드, 거리)
    visited = {start}  # set을 사용하여 방문 여부 효율적 관리

    while queue:
        current_node, distance = queue.popleft()

        # 현재 노드가 도착 노드라면 거리 반환
        if current_node == end:
            return distance

        # 이웃 노드 탐색
        for neighbor in graph[current_node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append((neighbor, distance + 1))
    
    # 경로가 없는 경우 0 반환
    return 0

def solve():
    V, E = map(int, input().split())
    # 노드 번호가 1부터 시작하므로 V+1 크기의 인접 리스트 생성
    adj_list = [[] for _ in range(V + 1)]
    
    for _ in range(E):
        u, v = map(int, input().split())
        adj_list[u].append(v)
        adj_list[v].append(u) # 방향성이 없는 그래프이므로 양쪽 모두 추가
        
    start, end = map(int, input().split())

    return bfs(adj_list, start, end)

# 메인 실행 부분
T = int(input())
for t in range(1, T + 1):
    result = solve()
    print(f'#{t} {result}')