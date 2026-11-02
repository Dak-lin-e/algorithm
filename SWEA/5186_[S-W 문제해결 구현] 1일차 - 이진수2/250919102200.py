# SWEA #5186 · [S/W 문제해결 구현] 1일차 - 이진수2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTtj7GqeAgDFAVT
# Language: Python
# Execution Time: 58 ms
# Memory: 51200 KB

def change(num):
    binary_stack = []
    frac = 0.5
    count = 0
    
    while num > 0:
        if count > 12:
            return "overflow"
        if num >= frac:
            num -= frac
            binary_stack.append("1")
        else:
            binary_stack.append("0")
        frac /= 2
        count += 1
    
    return "".join(binary_stack)


# 메인 실행
t = int(input())
for i in range(1, t + 1):
    f = float(input())  # 실수 입력
    result = change(f)
    print(f'#{i} {result}')
