# SWEA #26009 · 곱의 합
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZv9opVqDDXHBIQE
# Language: Python
# Execution Time: 56 ms
# Memory: 52480 KB

MOD = 998244353
INV2 = (MOD + 1) // 2

TC = int(input())

for _ in range(TC):
    a, b, c = map(int, input().split())

    sa = (a % MOD) * ((a + 1) % MOD) % MOD * INV2 % MOD
    sb = (b % MOD) * ((b + 1) % MOD) % MOD * INV2 % MOD
    sc = (c % MOD) * ((c + 1) % MOD) % MOD * INV2 % MOD

    ans = sa * sb % MOD * sc % MOD
    print(ans)