# PROGRAMMERS #250137 · [PCCP 기출문제] 1번 / 붕대 감기
# https://school.programmers.co.kr/learn/courses/30/lessons/250137
# Language: python

# 붕대감기 - pccp 1번문제
def solution(bandage, health, attacks):
    answer = 0
    attack_time = [attacks[i][0] for i in range(len(attacks))]
    damage = [attacks[i][1] for i in range(len(attacks))]
    heal_time = 0 
    limit_hp = health -1 
    
    for i in range(attacks[-1][0]+1):
        
        if i in attack_time:
            b = attack_time.index(i)     # list index out of range 항상 조심할것!!! 인덱스 체크하기
            health -= damage[b]
            heal_time = 0                # 알아낸 사실 : if 문의 조건과 elif 문의 조건이 동시에 충족하면 둘다 실행되지만 elif 문 2개 조건이 동시 충족하면 
                                        # 위의 것만 실행하게 된다.
#         elif health > limit_hp : 
#             pass
            
        elif heal_time == bandage[0]-1:
            health += bandage[2]
            health += bandage[1]
            heal_time = 0
            
        else:
            health+=bandage[1]
            heal_time+=1
            if heal_time == bandage[0]:
                health+=bandage[2]
        
        if health > limit_hp:
            health = limit_hp +1
        elif health <=0:
            return -1 
        
    return health