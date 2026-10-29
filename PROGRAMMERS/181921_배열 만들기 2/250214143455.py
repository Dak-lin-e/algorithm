# PROGRAMMERS #181921 · 배열 만들기 2
# https://school.programmers.co.kr/learn/courses/30/lessons/181921
# Language: python

def solution(l, r):
    result=[]
    for i in range(l,r):
        result.append(i)
        for j in str(i):
            if j != '0' and j!='5' :
                result.remove(i)
                break
            else:
                pass

    if len(result)==0:
        result.append(-1)
    else:
        pass


    return result