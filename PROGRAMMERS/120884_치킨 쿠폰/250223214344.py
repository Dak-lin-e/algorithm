# PROGRAMMERS #120884 · 치킨 쿠폰
# https://school.programmers.co.kr/learn/courses/30/lessons/120884
# Language: python

def solution(chicken):
    order=0
    coupon=0
    while(10<=chicken):
        chicken,j=divmod(chicken,10)
        order+=chicken
        coupon+=j
        
    
    chicken,j=divmod(chicken,10)
    # order+=chicken
    coupon+=j
    while(coupon>=10):
        coupon,i=divmod(coupon,10)
        order+=coupon
        coupon+=i

        
    return order