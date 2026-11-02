# SWEA #12712 · 파리퇴치3
# https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AXuARWAqDkQDFARa&solveclubId=AZ7O6ga6XMXHBIQj&probBoxId=AZ7tox26fTHHBINs&problemBoxTitle=+%5B%EB%82%9C%EC%9D%B4%EB%8F%84+%EC%A4%91%5D+SW+%EC%A0%84%EA%B3%B5+%ED%95%84%EC%88%98+%2F+SW+%EB%B9%84%EC%A0%84%EA%B3%B5+%EC%9E%90%EC%9C%A8
# Language: Python
# Execution Time: 91 ms
# Memory: 59904 KB

def cross(graph,N,m,n):
    must=graph[m][n]
    max1=0
    for i in range(1-N,N):
        x=m+i
        if x>=len(graph) or x <0:
            pass
        else:
            max1+=graph[x][n]
    for j in range(1-N,N):
        y=n+j
        if y>=len(graph) or y <0:
            pass
        else:
            max1+=graph[m][y]
    return max1-must
    
def x(graph,N,m,n):
    must=graph[m][n]
    total=0
    for i in range(1-N,N):
        x=m+i
        y=n+i
        if x>=len(graph) or x<0 or y>=len(graph) or y<0:
            pass
        else:
            total+=graph[x][y]
    for i in range(1-N,N):
        x=m-i
        y=n+i
        if x>=len(graph) or x<0 or y>=len(graph) or y<0:
            pass
        else:
            total+=graph[x][y]
    return total-must

def solution(graph,N):
    max=0
    for i,m in enumerate(graph):
        for j,n in enumerate(m):
            if max < cross(graph,N,i,j):
                max=cross(graph,N,i,j)
            else:
                pass
            if max < x(graph,N,i,j):
                max=x(graph,N,i,j)
            else:
                pass
    return max
            
T = int(input())
for test_case in range(1, T + 1):
    M,N=map(int,input().split())
    graph=[]
    for i in range(M):
        line=list(map(int,input().split()))
        graph.append(line)
    result = solution(graph,N)
    print(f'#{test_case} {result}')
        
    