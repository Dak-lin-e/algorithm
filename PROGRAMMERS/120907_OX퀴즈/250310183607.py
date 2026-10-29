# PROGRAMMERS #120907 · OX퀴즈
# https://school.programmers.co.kr/learn/courses/30/lessons/120907
# Language: python

def solution(quiz):
    answer = []
    answer1= []
    for i in quiz:
        answer.append(i.split(' '))

    for i in answer:
        if i[1] == '-' :
            a = int(i[0])-int(i[2]) 
            if a != int(i[4]):
                answer1.append("X")
            else:
                answer1.append("O")
        elif i[1] == "+":
            a = int(i[0])+int(i[2]) 
            if a != int(i[4]):
                answer1.append("X")
            else:
                answer1.append("O")
    return answer1