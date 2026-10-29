# PROGRAMMERS #181943 · 문자열 겹쳐쓰기
# https://school.programmers.co.kr/learn/courses/30/lessons/181943
# Language: python

def solution(my_string, overwrite_string, s):
    result = []
    result1=[]
    result2=[]
    for i in my_string:
        result1.append(i)
    for i in overwrite_string:
        result2.append(i)
    for i in range(len(my_string)):
        if s <= i < s+len(overwrite_string):
            result.append(result2[i-s])
        else :
            result.append(result1[i])
    return ''.join(result)