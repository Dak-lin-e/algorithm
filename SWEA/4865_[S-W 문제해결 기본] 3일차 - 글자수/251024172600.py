# SWEA #4865 · [S/W 문제해결 기본] 3일차 - 글자수
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQSs6qQL0DFAVT
# Language: Python
# Execution Time: 71 ms
# Memory: 51456 KB


def solve():
    a= str(input())
    b= str(input())
    max=0
    for i in a:
        count=0
        for j in b:
            if i == j:
                count+=1
        if count > max:
            max = count
    return max

T = int(input())

for t in range(1,T+1):
    result = solve()
    print(f'#{t} {result}')