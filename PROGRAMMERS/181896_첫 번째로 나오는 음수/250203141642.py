# PROGRAMMERS #181896 · 첫 번째로 나오는 음수
# https://school.programmers.co.kr/learn/courses/30/lessons/181896
# Language: python

def solution(num_list):
    for i in range(len(num_list)):
        if num_list[i] < 0:
            answer = i
            break
        else:
            answer = -1
    return answer