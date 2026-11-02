# SWEA #4873 · [S/W 문제해결 기본] 4일차 - 반복문자 지우기
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTQbpTaQfEDFAVT
# Language: Python
# Execution Time: 71 ms
# Memory: 56704 KB

def solve():
    a = str(input())
    while True:
        n=len(a)
        b=0
        for i in range(0,n-1):
            if a[i]==a[i+1] and i !=n-2:
                a = a[:i]+a[i+2:]
                break
            elif a[i]==a[i+1] and i ==n-2:
                a=a[:i]
                break
                
        n=len(a)
        for i in range(0,n-1):
            if a[i]==a[i+1] :
                b+=1
                break
        if b ==0:
            return a.strip()
            
        

T =int(input())

for t in range(1,T+1):
    result = solve()
    answer=len(result)
    print(f'#{t} {answer}')