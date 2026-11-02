# SWEA #4880 · [S/W 문제해결 기본] 5일차 - 토너먼트 카드게임
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQgnH6Qq4DFAVT
# Language: Python
# Execution Time: 58 ms
# Memory: 51072 KB

def battle(stack):
    # 가위바위보 로직을 더 명확하게 수정
    p1 = stack[0][1]
    p2 = stack[1][1]
    
    if p1 == p2:
        return stack[0]
    elif (p1 == 1 and p2 == 3) or \
         (p1 == 2 and p2 == 1) or \
         (p1 == 3 and p2 == 2):
        return stack[0]
    else:
        return stack[1]

def divide(sub_list):
    n = len(sub_list)
    if n <= 1:
        return sub_list[0]
    
    mid = (n + 1) // 2  # 중앙 인덱스 계산
    
    # 두 부분으로 나누어 재귀 호출
    winner1 = divide(sub_list[:mid])
    winner2 = divide(sub_list[mid:])
    
    # 두 승자를 다시 비교하여 최종 승자 반환
    return battle([winner1, winner2])

T = int(input())
for t in range(1, T + 1):
    num = int(input())
    stack = list(map(int, input().split()))
    
    line = [[i + 1, j] for i, j in enumerate(stack)]
    
    result = divide(line)
    
    print(f'#{t} {result[0]}')