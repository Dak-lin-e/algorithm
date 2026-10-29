# PROGRAMMERS #250121 · [PCCE 기출문제] 10번 / 데이터 분석
# https://school.programmers.co.kr/learn/courses/30/lessons/250121
# Language: python

def solution(data, ext, val_ext, sort_by):
    answer = []
    check={"code":0,"date":1,"maximum":2,"remain":3}
    
    for i in data:
        if i[check[ext]] >= val_ext:
            pass
        else:
            answer.append(i)
    answer.sort(key=lambda x: x[check[sort_by]])
    return answer