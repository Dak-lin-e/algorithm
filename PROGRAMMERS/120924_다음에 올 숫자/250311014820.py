# PROGRAMMERS #120924 · 다음에 올 숫자
# https://school.programmers.co.kr/learn/courses/30/lessons/120924
# Language: python

def solution(common):
    if (common[0] + common[2])/2 == common[1]:
        return common[len(common)-1] + (common[1] - common[0]) 
    else :
        return (common[2] / common[1]) * common[len(common)-1]