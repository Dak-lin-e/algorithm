# SWEA #1859 · 백만 장자 프로젝트
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc
# Language: Python
# Execution Time: 771 ms
# Memory: 197156 KB

T=int(input())

for t in range(1,T+1):
    a=int(input())
    line=list(map(int,input().split()))
    
    future_max=0
    profit=0
    
    for i in reversed(line):
        if i>future_max:
            future_max=i
        else:
            profit+=future_max-i
    print(f'#{t} {profit}')