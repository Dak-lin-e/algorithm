# PROGRAMMERS #258712 · 가장 많이 받은 선물
# https://school.programmers.co.kr/learn/courses/30/lessons/258712
# Language: python

def solution(friends, gifts):
    n = len(friends)
    name_to_index = {name: i for i, name in enumerate(friends)}  # 친구 이름 → 인덱스 매핑

    # 2차원 리스트 초기화 (각 행이 독립적인 리스트로 생성됨)
    a = [[0] * n for _ in range(n)]
    
    # 전체 선물 준 개수, 받은 개수
    total_give = [0] * n
    total_receive = [0] * n

    # 🔹 1. 선물 기록 분석
    for gift in gifts:
        giver, receiver = gift.split(" ")
        giver_idx = name_to_index[giver]
        receiver_idx = name_to_index[receiver]

        a[giver_idx][receiver_idx] += 1  # 준 선물 기록
        total_give[giver_idx] += 1
        total_receive[receiver_idx] += 1

    # 🔹 2. 선물 지수 계산
    c = [total_give[i] - total_receive[i] for i in range(n)]

    # 🔹 3. 다음 달 선물 주고받기 시뮬레이션
    d = [0] * n  # 다음 달 받을 선물 개수

    for i in range(n):
        for j in range(i + 1, n):  # 모든 친구 쌍 비교
            if a[i][j] > a[j][i]:  # i가 j에게 더 많이 줬다면
                d[i] += 1
            elif a[i][j] < a[j][i]:  # j가 i에게 더 많이 줬다면
                d[j] += 1
            else:  # 주고받은 횟수가 같거나 없을 때
                if c[i] > c[j]:  # 선물 지수 비교
                    d[i] += 1
                elif c[i] < c[j]:
                    d[j] += 1

    # 🔹 4. 가장 많이 받을 친구의 선물 개수 반환
    return max(d)
