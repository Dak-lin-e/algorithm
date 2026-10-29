# PROGRAMMERS #42862 · 체육복
# https://school.programmers.co.kr/learn/courses/30/lessons/42862
# Language: python

def solution(n, lost, reserve):
    # 1. 모든 학생의 체육복 개수를 1개로 초기화 (1번부터 n번까지 쓰기 위해 n+1 크기로 생성)
    # 인덱스 0번은 계산의 편의를 위해 dummy로 두고 쓰지 않습니다.
    students = [1] * (n + 1)
    
    # 2. 도난당한 학생은 체육복 개수 -1
    for l in lost:
        students[l] -= 1
        
    # 3. 여벌이 있는 학생은 체육복 개수 +1
    for r in reserve:
        students[r] += 1
        
    # 4. 1번 학생부터 n번 학생까지 순서대로 확인하며 그리디 탐색
    for i in range(1, n + 1):
        # 내가 체육복이 없다면 (0개라면)
        if students[i] == 0:
            # 앞 번호 학생(i-1)이 여벌이 있는지 확인하고 빌림
            if i - 1 >= 1 and students[i - 1] == 2:
                students[i - 1] -= 1
                students[i] += 1
            # 앞 번호가 없다면 뒷 번호 학생(i+1)이 여벌이 있는지 확인하고 빌림
            elif i + 1 <= n and students[i + 1] == 2:
                students[i + 1] -= 1
                students[i] += 1

    # 5. 체육복이 1개 이상인 학생들의 수를 카운트 (인덱스 0번 제외)
    answer = 0
    for i in range(1, n + 1):
        if students[i] >= 1:
            answer += 1
            
    return answer