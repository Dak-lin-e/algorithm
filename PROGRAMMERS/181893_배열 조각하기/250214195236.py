# PROGRAMMERS #181893 · 배열 조각하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181893
# Language: python

def solution(arr, query):
    for i, q in enumerate(query):
        if i % 2 == 0:
            # 짝수 인덱스: query[i] 이후 부분을 잘라버림
            arr = arr[:q + 1]
        else:
            # 홀수 인덱스: query[i] 이전 부분을 잘라버림
            arr = arr[q:]

    return arr