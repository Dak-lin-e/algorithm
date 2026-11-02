# SWEA #26389 · 여행
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZyNUDmaATzHBIRj
# Language: Python
# Execution Time: 58 ms
# Memory: 53632 KB

TC = int(input())

for _ in range(TC):
    A = input().strip()

    if ('N' in A) == ('S' in A) and ('E' in A) == ('W' in A):
        print("Yes")
    else:
        print("No")