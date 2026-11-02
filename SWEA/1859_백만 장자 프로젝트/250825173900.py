# SWEA #1859 · 백만 장자 프로젝트
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc
# Language: Python
# Execution Time: 655 ms
# Memory: 181296 KB


T = int(input().strip())
for tc in range(1, T + 1):
    N = int(input().strip())
    prices = list(map(int, input().split()))

    max_future = 0
    profit = 0

    # 뒤에서부터 최대값 갱신
    for price in reversed(prices):
        if price > max_future:
            max_future = price
        else:
            profit += max_future - price

    print(f"#{tc} {profit}")
