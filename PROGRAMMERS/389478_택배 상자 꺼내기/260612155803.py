# PROGRAMMERS #389478 · 택배 상자 꺼내기
# https://school.programmers.co.kr/learn/courses/30/lessons/389478
# Language: python

def solution(n, w, num):
    storage = []  # 2차원 창고 배열
    current_box = 1
    row_idx = 0
    
    # 1. 1번 상자부터 n번 상자까지 완벽하게 채워 넣기
    while current_box <= n:
        # 한 줄(w 크기)에 들어갈 박스들 임시 리스트
        line = []
        for _ in range(w):
            if current_box <= n:
                line.append(current_box)
                current_box += 1
            else:
                # 상자가 다 떨어졌으면 빈 공간은 0으로 채우기
                line.append(0)
                
        # 0번째 줄(짝수), 2번째 줄 등은 정방향으로 창고에 추가
        if row_idx % 2 == 0:
            storage.append(line)
        # 1번째 줄(홀수), 3번째 줄 등은 역방향(지그재그)이므로 뒤집어서 추가
        else:
            line.reverse()
            storage.append(line)
            
        row_idx += 1

    # 2. 창고 전체를 뒤져서 내가 꺼내려는 'num' 상자의 좌표(행, 열) 찾기
    target_r, target_c = -1, -1
    for r in range(len(storage)):
        for c in range(w):
            if storage[r][c] == num:
                target_r, target_c = r, c
                break
        if target_r != -1:
            break

    # 3. 찾은 열(target_c) 고대로 맨 위층(마지막 행)까지 수직 아래로 내려가며 세기
    # 위에서 아래로(storage[0] -> storage[-1]) 쌓인 구조이므로 
    # 내 아래쪽 행(r)들을 검사하면서 0이 아닌 상자가 총 몇 개인지 구합니다.
    answer = 0
    for r in range(target_r, len(storage)):
        if storage[r][target_c] != 0:
            answer += 1
            
    return answer