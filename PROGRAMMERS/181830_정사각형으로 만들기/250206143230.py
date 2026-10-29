# PROGRAMMERS #181830 · 정사각형으로 만들기
# https://school.programmers.co.kr/learn/courses/30/lessons/181830
# Language: python

def solution(arr):
    while(len(arr)!=len(arr[0])):
        if len(arr) > len(arr[0]):
            for i in range(len(arr)):
                arr[i].append(0*(len(arr)-len(arr[0])))
        elif len(arr[0]) > len(arr):
            arr.append([0]*len(arr[0]))
    return arr