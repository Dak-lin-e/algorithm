# PROGRAMMERS #120878 · 유한소수 판별하기
# https://school.programmers.co.kr/learn/courses/30/lessons/120878
# Language: python

def solution(a, b):
    answer = 1
    an =[i for i in range(1,a+1) if a % i ==0] # a의 약수 리스트
    bn = [i for i in range(1,b+1) if b % i ==0] # b의 약수 리스트
    
    c = max(set(an)&set(bn)) # 최대공약수 c 구하기
    
    b//=c # 기약분수 만들기
    
    # b 소인수분해 하기
    # b를 나눌 소인수만들기
    d=[]
    for i in range(1,b+1):
        e=[]
        if b % i == 0:
            for j in range(1,i+1):
                if i % j ==0:
                    e.append(j)
                else:
                    pass
        else:
            pass
        if len(e) == 2:
            d.append(i)
        else:
            pass

    for i in d:
        if i !=2 and i != 5:
            return 2
        else:
            pass
  
    return answer