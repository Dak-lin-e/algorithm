# PROGRAMMERS #86491 · 최소직사각형
# https://school.programmers.co.kr/learn/courses/30/lessons/86491
# Language: python

def solution(sizes):
    max_w = 0  # 가장 긴 가로 길이(긴 변들의 최댓값)
    max_h = 0  # 가장 긴 세로 길이(짧은 변들의 최댓값)
    
    for size in sizes:
        # 1. 각 명함의 가로, 세로 중 큰 값을 w, 작은 값을 h로 설정
        w = max(size)
        h = min(size)
        
        # 2. 현재까지 확인한 명함들의 w 중 가장 큰 값, h 중 가장 큰 값으로 갱신
        max_w = max(max_w, w)
        max_h = max(max_h, h)
        
    # 3. 최종적으로 구해진 가장 큰 가로와 세로를 곱해 지갑의 크기 반환
    return max_w * max_h