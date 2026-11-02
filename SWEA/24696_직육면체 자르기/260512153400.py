# SWEA #24696 · 직육면체 자르기
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZhd5eNKLHnHBINp
# Language: Python
# Execution Time: 67 ms
# Memory: 53760 KB

def test(a,b,c):
    d=a*b*c
    if (d-1)%2==0:
        return 2
    else:
        return 1

T = int(input())

for test_case in range(1, T + 1):
    a,b,c= map(int,input().split())
    answer=test(a,b,c)
    print(answer)