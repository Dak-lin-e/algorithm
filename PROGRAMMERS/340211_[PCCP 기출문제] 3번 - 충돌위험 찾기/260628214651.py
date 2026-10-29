# PROGRAMMERS #340211 · [PCCP 기출문제] 3번 / 충돌위험 찾기
# https://school.programmers.co.kr/learn/courses/30/lessons/340211
# Language: python

from collections import Counter

def solution(points, routes):
    # 1. 포인트 번호(1-based)로 좌표를 쉽게 찾을 수 있도록 딕셔너리로 변환
    pt_dict = {i + 1: (r, c) for i, (r, c) in enumerate(points)}
    
    robot_paths = []
    max_time = 0
    
    # 2. 각 로봇별로 0초부터 이동이 끝날 때까지의 궤적(좌표 리스트) 생성
    for route in routes:
        path = []
        # 시작 지점 삽입 (0초)
        curr_r, curr_c = pt_dict[route[0]]
        path.append((curr_r, curr_c))
        
        # 다음 목적지들을 순차적으로 방문
        for next_pt in route[1:]:
            target_r, target_c = pt_dict[next_pt]
            
            # [규칙 1] r좌표(행) 이동을 최우선으로 수행
            while curr_r != target_r:
                if curr_r < target_r:
                    curr_r += 1
                else:
                    curr_r -= 1
                path.append((curr_r, curr_c)) # 1초 이동할 때마다 위치 기록
                
            # [규칙 2] r좌표가 일치해지면 c좌표(열) 이동 수행
            while curr_c != target_c:
                if curr_c < target_c:
                    curr_c += 1
                else:
                    curr_c -= 1
                path.append((curr_r, curr_c))
                
        robot_paths.append(path)
        
        # 가장 늦게 끝나는 로봇의 시간(궤적 길이) 갱신
        if len(path) > max_time:
            max_time = len(path)
            
    # 3. 시간대(t초)별로 모든 로봇의 위치를 검사하여 충돌 횟수 계산
    collisions = 0
    
    # 0초부터 가장 오래 걸린 시간까지 1초씩 흐름
    for t in range(max_time):
        # 이번 초(t)에 센터에 존재하는 로봇들의 위치만 수집
        # t < len(path) 조건으로 이미 운송을 마친 로봇은 자동 제외됨
        current_positions = [path[t] for path in robot_paths if t < len(path)]
        
        # Counter를 이용해 현재 초에 겹친 좌표 개수 파악
        pos_counts = Counter(current_positions)
        
        # 같은 좌표에 2대 이상 겹쳤다면 위험 상황 1번 발생
        for count in pos_counts.values():
            if count >= 2:
                collisions += 1
                
    return collisions