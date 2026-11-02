# SWEA #4866 · [S/W 문제해결 기본] 4일차 - 괄호검사
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQVdd6QToDFAVT
# Language: Python
# Execution Time: 60 ms
# Memory: 52352 KB

def check_brackets(line):
    stack=[]
# 테스트 케이스 개수 T 입력
    dict={')':'(','}':'{'}
    
    for i in line:
        if i == '{' or i=='(':
            stack.append(i)
        elif i =='}' or i==')':
            if not stack:
                return 0
            m = stack.pop()
            if m == dict[i]:
                pass
            else:
                return 0
    if stack :
        return 0
    return 1
T = int(input())

for tc in range(1, T + 1):
    # 테스트 케이스별 코드 라인 입력
    code_line = input()
    
    # 괄호 검사 함수 호출
    result = check_brackets(code_line)
    
    # 정해진 형식으로 출력
    print(f"#{tc} {result}")