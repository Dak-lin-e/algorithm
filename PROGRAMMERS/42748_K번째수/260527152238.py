# PROGRAMMERS #42748 · K번째수
# https://school.programmers.co.kr/learn/courses/30/lessons/42748
# Language: python

def solution(array, commands):
    answer = []
    for m in commands:
        slic=array[m[0]-1:m[1]]
        slic.sort()
        answer.append(slic[m[2]-1])
    return answer