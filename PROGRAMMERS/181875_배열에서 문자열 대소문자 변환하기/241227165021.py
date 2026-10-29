# PROGRAMMERS #181875 · 배열에서 문자열 대소문자 변환하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181875
# Language: python

def solution(strArr):
    answer=[]
    for i in range(len(strArr)):
        if i %2 == 0:
            answer.append(strArr[i].lower())
        elif i %2 != 0:
            answer.append(strArr[i].upper())
        else:
            pass
    return answer