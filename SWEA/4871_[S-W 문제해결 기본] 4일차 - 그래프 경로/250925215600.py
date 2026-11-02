# SWEA #4871 · [S/W 문제해결 기본] 4일차 - 그래프 경로
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQaUvqQdUDFAVT
# Language: Python
# Execution Time: 63 ms
# Memory: 52480 KB

def dfs(s,e,graph,visited):
    if s == e:
        return 1

    for i in graph[s]:
        if visited[i]==False:
            visited[i]=True
            an=dfs(i,e,graph,visited)
            if an == 1:
                return 1
    return 0

def solve():
    V,E=map(int,input().split())
    graph=[[] for _ in range(V+1)]
    visited=[False for _ in range(V+1)]

    for _ in range(E):
        a,b=map(int,input().split())
        graph[a].append(b)
    start,end=map(int,input().split())
    return dfs(start,end,graph,visited)
    
T =int(input())

for t in range(1,T+1):
    result = solve()
    print(f'#{t} {result}')