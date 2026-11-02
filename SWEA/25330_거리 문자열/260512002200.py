# SWEA #25330 · 거리 문자열
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZjpmyoKGZTHBIO0
# Language: Python
# Execution Time: 81 ms
# Memory: 58368 KB

def check(s):
    for d in range(10):
        ch = str(d)
        positions = []

        for i in range(len(s)):
            if s[i] == ch:
                positions.append(i)

        if len(positions) == 0:
            continue

        if len(positions) != 2:
            return "no"

        if positions[1] - positions[0] - 1 != d:
            return "no"

    return "yes"


T = int(input())

for _ in range(T):
    S = input().strip()
    print(check(S))