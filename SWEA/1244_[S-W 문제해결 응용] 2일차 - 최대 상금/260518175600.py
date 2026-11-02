# SWEA #1244 · [S/W 문제해결 응용] 2일차 - 최대 상금
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD
# Language: Python
# Execution Time: 99 ms
# Memory: 62336 KB

def exchange(num_str, current_count, target_count):
    global max_answer
    
    # 목표한 교환 횟수에 도달했을 때
    if current_count == target_count:
        max_answer = max(max_answer, int(''.join(num_str)))
        return

    # 중복 체크: (현재 숫자 문자열, 현재 교환 횟수)가 이미 탐색한 적 있다면 스킵 (가지치기)
    current_state = (''.join(num_str), current_count)
    if current_state in visited:
        return
    visited.add(current_state)

    length = len(num_str)
    # 모든 위치 쌍(j, k)에 대해 교환 시도
    for j in range(length):
        for k in range(j + 1, length): # j 자신과 바꾸는 것은 의미가 없으므로 j+1부터
            
            # 1. 자리를 바꾼다 (Action)
            num_str[j], num_str[k] = num_str[k], num_str[j]
            
            # 2. 다음 교환을 위해 재귀 호출 (이때 return을 붙이지 않아야 다른 j, k도 탐색함)
            exchange(num_str, current_count + 1, target_count)
            
            # 3. 원상 복구한다 (Backtracking) - 아주 중요!
            num_str[j], num_str[k] = num_str[k], num_str[j]

            
T = int(input())
for test_case in range(1, T + 1):
    # 입력 처리: 숫자는 리스트 형태로 다루는 것이 자리 바꾸기에 편합니다.
    a, b = input().split()
    num_list = list(a)
    b = int(b)
    
    max_answer = 0
    visited = set() # 중복 탐색을 막기 위한 셋(Set)
    
    # 재귀 함수 시작 (숫자 리스트, 현재 교환 횟수 0, 목표 교환 횟수 b)
    exchange(num_list, 0, b)
    
    print(f'#{test_case} {max_answer}')