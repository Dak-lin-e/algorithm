# SWEA #5185 · [S/W 문제해결 구현] 1일차 - 이진수
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTtiyIqd_wDFAVT
# Language: Python
# Execution Time: 57 ms
# Memory: 52224 KB

def test(b):
    list1=[]
    for i in b:
        list1.append(str(format(int(i,16),'04b')))
    return ''.join(list1)

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a,b=map(str,input().split())
    answer=test(b)
    print(f"#{test_case} {answer}")