# PROGRAMMERS #120812 · 최빈값 구하기
# https://school.programmers.co.kr/learn/courses/30/lessons/120812
# Language: python

def solution(array):
    a=[0]*len(set(array))
    
    for i,j in enumerate(set(array)):
        for k in array:
            if j == k:
                a[i]=a[i]+1

    t=0

    # for i,j in enumerate(set(array)):
    for m,n in enumerate(a):
          if n < max(a):
            pass
          elif n==max(a):
            t+=1
      
    if t == 1 :
        return list(set(array))[a.index(max(a))]
    elif t !=1:
        return -1