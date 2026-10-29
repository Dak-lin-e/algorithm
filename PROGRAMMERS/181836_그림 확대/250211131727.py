# PROGRAMMERS #181836 · 그림 확대
# https://school.programmers.co.kr/learn/courses/30/lessons/181836
# Language: python

def solution(picture, k):
  
    result=[]
    for i in picture:
        result1=[]              # result1 비우기 !!!
        for j in i:
            result1.append(j*k)
        result.append(''.join(result1))      #  리스트 요소들을 합치는 코드

    result2=[]
    for i in result:
        t=k
        while(t>0):
            result2.append(i)
            t-=1

    return result2