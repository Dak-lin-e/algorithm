# PROGRAMMERS #43162 · 네트워크
# https://school.programmers.co.kr/learn/courses/30/lessons/43162
# Language: python

# 네트워크 - dfs
def solution(n, computers):
    answer = 0
    
    graph=[[] for _ in range(n)] 
    for i in range(n):
        for j in range(n):
            if computers[i][j] ==1 :
                graph[i].append(j)
    
    visited = [False for _ in range(n)]
            
    def dfs (start,graph,visited):
        nonlocal answer       # 새로운 함수안에 넣을때 꼭 필요함.
        
        visited[start] = True
        
        for i in graph[start]:
            if not visited[i]:
                dfs(i,graph,visited)
                
        
    
    for i in range(n):
        if visited[i]==False:
            dfs(i,graph,visited)
            answer+=1
        else:
            pass
        
    return answer