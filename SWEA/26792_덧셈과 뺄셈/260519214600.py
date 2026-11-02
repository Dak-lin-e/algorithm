# SWEA #26792 · 덧셈과 뺄셈
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZ3XsaWKSB3HBIPV
# Language: Python
# Execution Time: 57 ms
# Memory: 52224 KB

def test(a,b):
    x=(a+b)//2
    y=a-x
    return x,y


T = int(input())
for test_case in range(1, T + 1):
    a,b=map(int,input().split())
    answer,answer1=test(a,b)
    print(f"{answer} {answer1}")