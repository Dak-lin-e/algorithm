# SWEA #1959 · 두 개의 숫자열
# https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV5PpoFaAS4DFAUq&solveclubId=AZ7O6ga6XMXHBIQj&probBoxId=AZ7tox26fTHHBINs&problemBoxTitle=+%5B%EB%82%9C%EC%9D%B4%EB%8F%84+%EC%A4%91%5D+SW+%EC%A0%84%EA%B3%B5+%ED%95%84%EC%88%98+%2F+SW+%EB%B9%84%EC%A0%84%EA%B3%B5+%EC%9E%90%EC%9C%A8
# Language: Python
# Execution Time: 59 ms
# Memory: 52480 KB

def solve(list1,list2):
    if len(list1)>len(list2):
        n1=len(list2)
        n2=len(list1)
        max1=0
        n3=n2-n1
        for i in range(n3+1):
            check=0
            for j,k in zip(list1[i:n1+i],list2[:]):
                check+=(j*k)
            if check>max1:
                max1=check
            else:
                pass
        return max1               
            
    else:
        n1=len(list1)
        n2=len(list2)
        max1=0
        n3=n2-n1

        for i in range(n3+1):
            check=0
            for j,k in zip(list1[:],list2[i:n1+i+1]):
                check+=(j*k)
            if check>max1:
                max1=check
            else:
                pass
        return max1
        
         
T = int(input())
for test_case in range(1, T + 1):
    a,b=map(int,input().split())
    list1=list(map(int,input().split()))
    list2=list(map(int,input().split()))
    result=solve(list1,list2)
    print(f'#{test_case} {result}')