# SWEA #1486 · 장훈이의 높은 선반
# https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV2b7Yf6ABcBBASw&solveclubId=AZ7O6ga6XMXHBIQj&probBoxId=AZ7tox26fTLHBINs&problemBoxTitle=+%5B%EB%82%9C%EC%9D%B4%EB%8F%84+%EC%83%81%5D+SW+%EC%A0%84%EA%B3%B5+%EC%9E%90%EC%9C%A8
# Language: Python
# Execution Time: 621 ms
# Memory: 114808 KB

from itertools import combinations
def solve(n,b,height):
    check=sum(height)
    for k in range(1,n+1):
        for i in list(combinations(height,k)):
            total=sum(list(i))
            if total>=b:
                if check>(total-b):
                    check=(total-b)
    return check 
                
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,b=map(int,input().split())
    height = list(map(int,input().split()))
    result=solve(n,b,height)
    print(f'#{test_case} {result}')
