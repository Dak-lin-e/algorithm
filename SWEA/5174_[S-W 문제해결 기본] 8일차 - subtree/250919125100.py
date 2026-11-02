# SWEA #5174 · [S/W 문제해결 기본] 8일차 - subtree
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTay1Z64cQDFAVT
# Language: Python
# Execution Time: 65 ms
# Memory: 58752 KB

def dfs(node1,node2,N):
    count=1
    if node1[N] !=0:
        count+=dfs(node1,node2,node1[N])
    if node2[N] !=0:
        count+=dfs(node1,node2,node2[N])
    
    return count


def make():
    E,N=map(int,input().split())
    tree=list(map(int,input().split()))

    node1=[0]*(E+2)
    node2=[0]*(E+2)
    
    for i in range(E):
        parent,child=tree[2*i],tree[2*i+1]
        if node1[parent]==0:
            node1[parent]=child
        else:
            node2[parent]=child
        
    result2=dfs(node1,node2,N)
    return result2

T=int(input())

for t in range(1,T+1):
    result=make()
    print(f'#{t} {result}')