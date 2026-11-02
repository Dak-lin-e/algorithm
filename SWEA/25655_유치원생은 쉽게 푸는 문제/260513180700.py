# SWEA #25655 · 유치원생은 쉽게 푸는 문제
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZmeHlF68SDHBIPN
# Language: Python
# Execution Time: 75 ms
# Memory: 53888 KB

T = int(input())

for tc in range(1, T + 1):
    X = int(input())

    if X == 1:
        answer = "0"
    elif X % 2 == 0:
        answer = "8" * (X // 2)
    else:
        answer = "4" + "8" * (X // 2)

    print(f"{answer}")