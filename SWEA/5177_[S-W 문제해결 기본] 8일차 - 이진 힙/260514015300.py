# SWEA #5177 · [S/W 문제해결 기본] 8일차 - 이진 힙
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWTa1f7q4kIDFAVT
# Language: Python
# Execution Time: 55 ms
# Memory: 53376 KB

def test(arr):
    heap = [0]  # 1번 인덱스부터 사용하기 위해 0 넣기

    for num in arr:
        heap.append(num)

        idx = len(heap) - 1

        while idx > 1:
            parent = idx // 2

            if heap[parent] > heap[idx]:
                heap[parent], heap[idx] = heap[idx], heap[parent]
                idx = parent
            else:
                break

    total = 0
    idx = len(arr)

    while idx > 1:
        idx //= 2
        total += heap[idx]

    return total


T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))

    answer = test(arr)

    print(f"#{test_case} {answer}")