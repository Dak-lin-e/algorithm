# PROGRAMMERS #468371 · 노란불 신호등
# https://school.programmers.co.kr/learn/courses/30/lessons/468371
# Language: Python
# Execution Time: 252.37 ms
# Memory: 15.632 MB

import math
from functools import reduce

# 여러 수의 최소공배수(LCM)를 구하는 함수
def lcm(a, b):
    return (a * b) // math.gcd(a, b)

def solution(signals):
    # 1. 인덱스 에러 해결: signals 길이만큼 독립된 빈 리스트 생성
    answer = [[] for _ in range(len(signals))]

    # 2. 모든 신호등 주기의 최소공배수를 구하여 탐색 시간의 상한선 설정
    # 각 신호등의 한 주기 = 초록(G) + 노랑(Y) + 빨강(R)
    periods = [sum(j) for j in signals]
    max_time = reduce(lcm, periods)

    # 3. 각 신호등마다 노란불이 켜지는 '모든 초(sec)'를 기록
    for i, j in enumerate(signals):
        g, y, r = j[0], j[1], j[2]
        cycle = g + y + r
        
        # 첫 번째 주기부터 max_time을 넘지 않을 때까지 주기를 반복
        n = 0
        while True:
            # n번째 주기의 노란불 시작 시간 계산
            start_yellow = n * cycle + g
            
            # 상한선을 넘어가면 해당 신호등 기록 중지
            if start_yellow > max_time:
                break
                
            # 노란불이 지속되는 시간(Y)만큼 배열에 추가
            for k in range(1, y + 1):
                current_time = start_yellow + k
                if current_time <= max_time:
                    answer[i].append(current_time)
            n += 1

    # 4. 모든 신호등이 동시에 노란불인 시간(교집합) 찾기
    answer1 = set(answer[0])
    for n in answer:
        answer1 &= set(n)

    # 5. 교집합이 존재한다면 무작위 index 0이 아니라 반드시 '최솟값'을 반환
    if answer1:
        return min(answer1)
    else:
        return -1