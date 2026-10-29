# PROGRAMMERS #181892 · n 번째 원소부터
# https://school.programmers.co.kr/learn/courses/30/lessons/181892
# Language: python

def solution(num_list, n):
    answer = []
    for i in range(len(num_list)):
        if i >= n-1 :
            answer.append(num_list[i])
        else : 
            pass
    return answer