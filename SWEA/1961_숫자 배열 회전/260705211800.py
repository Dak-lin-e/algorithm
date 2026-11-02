# SWEA #1961 · 숫자 배열 회전
# https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV5Pq-OKAVYDFAUq&solveclubId=AZ7O6ga6XMXHBIQj&probBoxId=AZ7tox26fTHHBINs&problemBoxTitle=+%5B%EB%82%9C%EC%9D%B4%EB%8F%84+%EC%A4%91%5D+SW+%EC%A0%84%EA%B3%B5+%ED%95%84%EC%88%98+%2F+SW+%EB%B9%84%EC%A0%84%EA%B3%B5+%EC%9E%90%EC%9C%A8
# Language: Python
# Execution Time: 63 ms
# Memory: 53760 KB

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())

    arr = []
    for _ in range(N):
        arr.append(input().split())

    print(f'#{test_case}')

    for i in range(N):
        rotate_90 = ''
        rotate_180 = ''
        rotate_270 = ''

        for j in range(N):
            rotate_90 += arr[N - 1 - j][i]
            rotate_180 += arr[N - 1 - i][N - 1 - j]
            rotate_270 += arr[j][N - 1 - i]

        print(rotate_90, rotate_180, rotate_270)