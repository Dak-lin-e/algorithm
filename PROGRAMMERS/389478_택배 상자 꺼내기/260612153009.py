# PROGRAMMERS #389478 · 택배 상자 꺼내기
# https://school.programmers.co.kr/learn/courses/30/lessons/389478
# Language: python

def get_column(box_id, w):
    # 상자 번호를 0-indexed로 변환
    idx = box_id - 1
    row = idx // w
    
    if row % 2 == 0:
        # 짝수 층: 왼쪽 -> 오른쪽
        return idx % w
    else:
        # 홀수 층: 오른쪽 -> 왼쪽 (역방향)
        return w - 1 - (idx % w)

def solution(n, w, num):
    # 1. 내가 꺼내려는 상자(num)의 '열' 위치를 찾습니다.
    target_col = get_column(num, w)
    
    # 2. num 상자가 속한 층(시작 층)과 맨 마지막 상자(n)가 속한 층(최고 층)을 구합니다.
    start_row = (num - 1) // w
    max_row = (n - 1) // w
    
    answer = 0
    
    # 3. num이 있는 층부터 가장 높은 층까지 수직으로 올라가며 검사
    for r in range(start_row, max_row + 1):
        # 현재 검사 중인 층(r)에서 target_col에 위치한 상자의 '실제 번호'를 역산해봅니다.
        if r % 2 == 0:
            # 짝수 층일 때의 상자 번호 역산 공식
            current_box = r * w + target_col + 1
        else:
            # 홀수 층일 때의 상자 번호 역산 공식
            current_box = r * w + (w - 1 - target_col) + 1
            
        # 역산한 상자 번호가 전체 상자 개수 n 이하로 실제로 존재하는 상자라면 카운트 증가
        if current_box <= n:
            answer += 1
            
    return answer