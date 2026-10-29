# PROGRAMMERS #181874 · A 강조하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181874
# Language: python

def solution(myString):
    answer=[]
    for i in myString:
        if i == 'a':
            answer.append(i.upper())
        elif i == 'A':
            answer.append(i)
        elif i != 'a':
            answer.append(i.lower())
        else:
            pass
    return ''.join(answer)
