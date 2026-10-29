# PROGRAMMERS #181873 · 특정한 문자를 대문자로 바꾸기
# https://school.programmers.co.kr/learn/courses/30/lessons/181873
# Language: python

def solution(my_string, alp):
    answer = my_string.replace(alp, alp.upper())
    return answer