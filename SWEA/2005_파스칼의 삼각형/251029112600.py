# SWEA #2005 · 파스칼의 삼각형
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq
# Language: Python
# Execution Time: 61 ms
# Memory: 51968 KB

def solve():
    num=int(input())
    tree=[[1]*i for i in range(1,num+1)]
    if num >=3:
        for j in range(2,num):
            for k in range(1,j):
                tree[j][k]=tree[j-1][k-1]+tree[j-1][k]
    return tree

T = int(input())

for t in range(1,T+1):
    result= solve()
    print(f'#{t}')
    for row in result:
            # 리스트의 각 정수 요소를 문자열로 변환한 뒤, 
            # ' ' (공백)을 구분자로 사용하여 한 줄로 합쳐서 출력합니다.
            print(' '.join(map(str, row)))
