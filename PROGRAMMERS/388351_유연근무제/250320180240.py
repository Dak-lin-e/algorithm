# PROGRAMMERS #388351 · 유연근무제
# https://school.programmers.co.kr/learn/courses/30/lessons/388351
# Language: python

def solution(schedules, timelogs, startday):
    answer=0
    def to_minute(a):
        m=str(a)[-2:]
        n=str(a)[:-2]
        return int(n)*60 + int(m)
    
    checkfile=[]
    for i in range(startday,startday+7):
        if i <= 7:
            checkfile.append(i)
        else:
            checkfile.append(i-7)
    
    prize=[0]* len(schedules)
    
    for i,j in enumerate(timelogs):
        for m,n in enumerate(j):
            if checkfile[m]==6 or checkfile[m]==7:
                prize[i]+=1
                continue
            elif to_minute(n) <= to_minute(schedules[i])+10:
                prize[i]+=1
            else: 
                pass
    for i in prize:
        if i == 7:
            answer+=1
    
        
    return answer