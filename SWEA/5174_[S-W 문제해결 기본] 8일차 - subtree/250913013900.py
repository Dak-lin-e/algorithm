# SWEA #5174 · [S/W 문제해결 기본] 8일차 - subtree
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTay1Z64cQDFAVT
# Language: Python
# Execution Time: 63 ms
# Memory: 54144 KB

def count_nodes(node, child1, child2):
    """
    재귀적으로 서브 트리의 노드 개수를 세는 함수
    """
    count = 1  # 현재 노드 자신을 카운트에 포함
    
    # 첫 번째 자식이 있다면
    if child1[node] != 0:
        count += count_nodes(child1[node], child1, child2)
        
    # 두 번째 자식이 있다면
    if child2[node] != 0:
        count += count_nodes(child2[node], child1, child2)
        
    return count

def solve():
    E, N = map(int, input().split())
    edges = list(map(int, input().split()))
    
    # 노드 번호는 1부터 E+1까지이므로 배열 크기를 E+2로 설정
    child1 = [0] * (E + 2)
    child2 = [0] * (E + 2)
    
    # 부모-자식 관계를 child1, child2 배열에 저장
    for i in range(E):
        parent, child = edges[2 * i], edges[2 * i + 1]
        
        if child1[parent] == 0:
            child1[parent] = child
        else:
            child2[parent] = child
            
    # N을 루트로 하는 서브 트리의 노드 개수를 계산
    result = count_nodes(N, child1, child2)
    return result

T = int(input())
for t in range(1, T + 1):
    result = solve()
    print(f'#{t} {result}')