# PROGRAMMERS #42586 · 기능개발
# https://school.programmers.co.kr/learn/courses/30/lessons/42586
# Language: python

from collections import deque

def solution(progresses, speeds):
    answer = []
    check=0
    day=[]
    queue=deque()
    
    for i in range(len(progresses)):
        a,b =divmod((100 - progresses[i]),speeds[i])
        if b !=0:
            a+=1
            day.append(a)
        else:
            day.append(a)
    
    for i in day:
        queue.append(i)
    
    while queue:
        c = queue.popleft()
        check+=1
        for i in range(len(queue)):
            if queue[0] <= c:
                queue.popleft()
                check+=1
            else:
                answer.append(check)
                check=0
                c = queue.popleft()
                check+=1
    answer.append(check)

    return answer