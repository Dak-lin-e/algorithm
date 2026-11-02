# SWEA #2001 · 파리 퇴치
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
# Language: Python
# Execution Time: 68 ms
# Memory: 53760 KB

def solve(n,m):
    fly=[]
    for i in range(n):
        stack=list(map(int,input().split()))
        fly.append(stack)
    max=0
    p=n-m+1
    for j in range(p):
        for b in range(p):
            total=0       
            for k in range(0,m):
                for l in range(0,m):
                    total+=fly[0+j+k][0+b+l]
            if total > max:
                max=total
    return max
T = int(input())

for t in range(1,T+1):
    n,m=map(int,input().split())
    result = solve(n,m)
    print(f'#{t} {result}')