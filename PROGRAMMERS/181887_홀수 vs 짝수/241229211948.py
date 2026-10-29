# PROGRAMMERS #181887 · 홀수 vs 짝수
# https://school.programmers.co.kr/learn/courses/30/lessons/181887
# Language: python

def solution(num_list):
    answer = []
    a=0
    b=0
    for i in range(len(num_list)):
        if i%2==0:
            a+=num_list[i]
        elif i%2!=0:
            b+=num_list[i]
        else:
            pass
    answer.append(a)
    answer.append(b)
    return max(answer)