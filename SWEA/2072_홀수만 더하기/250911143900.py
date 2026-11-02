# SWEA #2072 · 홀수만 더하기
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq
# Language: Python
# Execution Time: 53 ms
# Memory: 50176 KB

T = int(input())   # 테스트 케이스 개수

for t in range(1, T + 1):
    numbers = list(map(int, input().split()))  # 10개의 수 입력
    total = sum(num for num in numbers if num % 2 == 1)  # 홀수만 합
    print(f'#{t} {total}')
