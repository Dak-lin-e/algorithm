# PROGRAMMERS #181885 · 할 일 목록
# https://school.programmers.co.kr/learn/courses/30/lessons/181885
# Language: python

def solution(todo_list, finished):
    answer = []
    
    for i in range(len(finished)):
        if finished[i] == False:
            answer.append(todo_list[i])
        elif finished[i]== True:
            pass
        else:
            pass
    return answer