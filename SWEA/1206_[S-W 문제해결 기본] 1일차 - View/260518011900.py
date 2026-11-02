# SWEA #1206 · [S/W 문제해결 기본] 1일차 - View
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh
# Language: Python
# Execution Time: 94 ms
# Memory: 60288 KB

def test(list1):
    answer1=[]
    for i,k in enumerate(list1):
        diff=[]
        if k ==0 :
            pass
        else:
            for j in range(-2,3):
                if list1[i+j] > k:
                    break
                else:
                    diff.append(list1[i+j])
            if len(diff)==5:
                diff.remove(max(diff))
                answer1.append(k-max(diff))
            else:
                pass
    return sum(answer1)
            
for i in range(1,11):
    T = int(input())

    list1= list(map(int,input().split()))
    answer=test(list1)
    print(f'#{i} {answer}')