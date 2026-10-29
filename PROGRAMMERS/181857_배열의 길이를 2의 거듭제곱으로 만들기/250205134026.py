# PROGRAMMERS #181857 · 배열의 길이를 2의 거듭제곱으로 만들기
# https://school.programmers.co.kr/learn/courses/30/lessons/181857
# Language: python

def solution(arr):
    import math

    # 현재 배열 길이
    current_length = len(arr)

    # 2의 거듭제곱인지 확인
    if (current_length & (current_length - 1)) == 0:
        return arr  # 이미 2의 거듭제곱이면 그대로 반환

    # 다음 2의 거듭제곱 구하기
    next_power_of_2 = 2 ** math.ceil(math.log2(current_length))

    # 추가해야 할 0의 개수
    zeros_to_add = next_power_of_2 - current_length

    # 0 추가 후 반환
    return arr + [0] * zeros_to_add