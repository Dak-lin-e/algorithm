# PROGRAMMERS #120883 · 로그인 성공?
# https://school.programmers.co.kr/learn/courses/30/lessons/120883
# Language: python

def solution(id_pw, db):
    answer=[]
    for i in db:
        if i[0] == id_pw[0]:
            if i[1]==id_pw[1]:
                return "login"
            elif i[1] !=id_pw[1]:
                return "wrong pw"
            else:
                pass
        else:
            answer.append(i[0]) 
            
    if id_pw[0] not in answer:
        return "fail"
    else:
        pass
            
    