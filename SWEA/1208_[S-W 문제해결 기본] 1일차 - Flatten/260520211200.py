# SWEA #1208 · [S/W 문제해결 기본] 1일차 - Flatten
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
# Language: Python
# Execution Time: 75 ms
# Memory: 59648 KB

def test(dump,list1):
    for _ in range(dump):
        if max(list1) == min(list1):
            return 0
        else:
            index1=list1.index(max(list1))
            index2=list1.index(min(list1))
            list1[index1]-=1
            list1[index2]+=1
    return (max(list1) - min(list1))
            


for test_case in range(1,11):
    dump=int(input())
    list1=list(map(int,input().split()))
    answer=test(dump,list1)
    print(f"#{test_case} {answer}")