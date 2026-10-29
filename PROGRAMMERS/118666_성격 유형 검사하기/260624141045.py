# PROGRAMMERS #118666 · 성격 유형 검사하기
# https://school.programmers.co.kr/learn/courses/30/lessons/118666
# Language: python

def solution(survey, choices):
    answer = ''
    # check={'RT':[0,0],'CF':[0,0],'JM':[0,0],'AN':[0,0]}
    check={'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    
    for i in range(len(survey)):
        a=survey[i]
        if (choices[i]-4)>0:
            check[a[1]]+=(choices[i]-4)
        elif (choices[i]-4)<0:
            check[a[0]]+=abs(choices[i]-4)
        else:
            pass
        

    if check['R']>check['T']:
        answer+='R'
    elif check['R']<check['T']:
        answer+='T'
    else:
        answer+='R'
        
    if check['C']>check['F']:
        answer+='C'
    elif check['C']<check['F']:
        answer+='F'
    else:
        answer+='C'
        
    if check['J']>check['M']:
        answer+='J'
    elif check['J']<check['M']:
        answer+='M'
    else:
        answer+='J'
        
    if check['A']>check['N']:
        answer+='A'
    elif check['A']<check['N']:
        answer+='N'
    else:
        answer+='A'
    return answer