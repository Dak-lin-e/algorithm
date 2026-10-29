# PROGRAMMERS #42839 · 소수 찾기
# https://school.programmers.co.kr/learn/courses/30/lessons/42839
# Language: python

from itertools import permutations

def is_prime(num):
    for i in range(2,num):
        if num%i==0:
            return 0
    return num

def solution(numbers):
    answer = 0
    answer1=[]
    n=len(numbers)
    list1=[i for i in numbers]
    for j in range(1,n+1):
        for i in permutations(list1,j):
            answer2=is_prime(int(''.join(list(i))))
            if (answer2 in answer1) or (answer2==0) or (answer2==1):
                pass
            else:
                answer1.append(answer2)
    return len(answer1)