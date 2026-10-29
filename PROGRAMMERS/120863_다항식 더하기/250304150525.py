# PROGRAMMERS #120863 · 다항식 더하기
# https://school.programmers.co.kr/learn/courses/30/lessons/120863
# Language: python

def solution(polynomial):
    list = polynomial.split(' ')
    list1 = [i for i in list if 'x' in i]

    for i,j in enumerate(list1):
        j=j.replace('x','')
        if j == '':
            j='1'
        else:
            pass
        list1[i]=int(j)

    a= sum(list1)

    list2 = [i for i in list if 'x' not in i and i !='+']

    for i,j in enumerate(list2):
         list2[i]=int(j)
    
    b = sum(list2)

    if a != 0 and a!=1 and  b !=0 :
        return str(a)+'x'+' '+'+'+' '+str(b)
    elif a == 0 and b !=0:
         return str(b)
        
    elif a!=0 and a!=1 and b ==0 :
         return str(a)+'x'

    elif a==1 and b !=0:
         return 'x'+' '+'+'+' '+str(b)
        
    elif a==1 and b==0:
         return 'x'
