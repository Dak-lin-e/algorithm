# SWEA #1204 · [S/W 문제해결 기본] 1일차 - 최빈수 구하기
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh
# Language: Python
# Execution Time: 66 ms
# Memory: 54528 KB


def test(list1):
    list2={}
    for i in list1:
        if i in list2:
            list2[i]+=1
        else:
            list2[i]=1
    max1=[]
    max_count=0
    for j,k in list2.items():
        if k>max_count:
            max1.clear()
            max_count=k
            max1.append(j)
        elif k==max_count:
            max1.append(j)
    return max(max1)

T = int(input())
for i in range(1, T + 1):
    test_case=int(input())
    list1=list(map(int,input().split()))
    answer = test(list1)
    print(f'#{test_case} {answer}')
    