# PROGRAMMERS #120834 · 외계행성의 나이
# https://school.programmers.co.kr/learn/courses/30/lessons/120834
# Language: python

def solution(age):
    answer=[]
    result=[]
    for i in str(age):
        answer.append(i)
    for i in answer:
        result.append(chr(int(i)+97))

    return ''.join(result)