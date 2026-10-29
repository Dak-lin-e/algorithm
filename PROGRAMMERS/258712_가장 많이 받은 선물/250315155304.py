# PROGRAMMERS #258712 · 가장 많이 받은 선물
# https://school.programmers.co.kr/learn/courses/30/lessons/258712
# Language: python

def solution(friends, gifts):
    n = len(friends)
    name_to_index = {name: i for i, name in enumerate(friends)}  # 친구 이름 → 인덱스 매핑

    # 2차원 배열: 누가 누구에게 선물을 줬는지 저장
    give_count = [[0] * n for _ in range(n)]

    # 각 친구가 준 선물 & 받은 선물 개수
    total_give = [0] * n
    total_receive = [0] * n

    # 🔹 1. 선물 기록 분석
    for gift in gifts:
        giver, receiver = gift.split()  # "A B" -> giver="A", receiver="B"
        giver_idx = name_to_index[giver]
        receiver_idx = name_to_index[receiver]

        give_count[giver_idx][receiver_idx] += 1
        total_give[giver_idx] += 1
        total_receive[receiver_idx] += 1

    # 🔹 2. 선물 지수 계산
    gift_index = [total_give[i] - total_receive[i] for i in range(n)]

    # 🔹 3. 다음 달 선물 주고받기 시뮬레이션
    next_month_receive = [0] * n  # 다음 달 받을 선물 개수

    for i in range(n):
        for j in range(i + 1, n):  # 모든 친구 쌍 탐색 (중복 방지)
            if give_count[i][j] > give_count[j][i]:  # i → j에게 더 많이 줬다면
                next_month_receive[i] += 1
            elif give_count[i][j] < give_count[j][i]:  # j → i에게 더 많이 줬다면
                next_month_receive[j] += 1
            else:  # 같은 수의 선물을 주고받았거나 아예 주고받지 않았다면
                if gift_index[i] > gift_index[j]:  # 선물 지수가 높은 사람이 선물 받음
                    next_month_receive[i] += 1
                elif gift_index[i] < gift_index[j]:
                    next_month_receive[j] += 1

    # 🔹 4. 가장 많이 받을 친구의 선물 개수 반환
    return max(next_month_receive)
