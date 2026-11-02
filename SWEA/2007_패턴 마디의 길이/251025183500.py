# SWEA #2007 · 패턴 마디의 길이
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P1kNKAl8DFAUq
# Language: Python
# Execution Time: 57 ms
# Memory: 52352 KB

def solve():
    sen=str(input())
    for i in range(1,11):
        pattern=sen[0:i]
        if pattern == sen[i:i*2]:
            answer = len(pattern)
            return answer
    
        
T = int(input())

for t in range(1,T+1):
    result = solve()
    print(f'#{t} {result}')