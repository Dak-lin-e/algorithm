# SWEA #4869 · [S/W 문제해결 기본] 4일차 - 종이붙이기
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQWhlqQWADFAVT
# Language: Python
# Execution Time: 57 ms
# Memory: 52480 KB


def solve_tiling_puzzle():
    # 입력 데이터를 직접 사용하거나 파일에서 읽기 위한 설정
    # sys.stdin = open('input.txt', 'r') 

    try:
        # 첫 줄에서 테스트 케이스 개수 T를 읽습니다.
        T = int(input())
    except:
        # 입력이 없으면 종료
        return

    # N은 최대 300이므로 n=N/10은 최대 30입니다.
    # dp 배열을 미리 최대 크기(31)로 초기화합니다.
    MAX_N_DIV_10 = 30
    dp = [0] * (MAX_N_DIV_10 + 1)

    # 초기값 설정
    dp[0] = 1 # a0
    if MAX_N_DIV_10 >= 1:
        dp[1] = 1 # a1

    # 점화식을 이용해 DP 테이블을 미리 채웁니다.
    # a_k = a_{k-1} + 2 * a_{k-2}
    for k in range(2, MAX_N_DIV_10 + 1):
        dp[k] = dp[k - 1] + 2 * dp[k - 2]

    # 각 테스트 케이스 처리
    for t in range(1, T + 1):
        try:
            # N 값을 읽고 n = N/10으로 변환
            N = int(input())
            n = N // 10
        except:
            # N 입력이 없으면 다음 케이스로 넘어가지 않고 루프 종료
            break

        # 미리 계산된 DP 테이블에서 결과를 가져옵니다.
        result = dp[n]
        print(f"#{t} {result}")


solve_tiling_puzzle()