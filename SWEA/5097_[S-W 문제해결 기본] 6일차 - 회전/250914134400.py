# SWEA #5097 · [S/W 문제해결 기본] 6일차 - 회전
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTVjgHKbn8DFAVT
# Language: Python
# Execution Time: 62 ms
# Memory: 54016 KB

from collections import deque

T = int(input())
for test_case in range(1, T + 1):
    a,b=map(int,input().split())
    stack=deque(list(map(int,input().split())))
    c=b%a
    for _ in range(c):
        stack.popleft()
    d = stack.popleft()
    print(f'#{test_case} {d}')