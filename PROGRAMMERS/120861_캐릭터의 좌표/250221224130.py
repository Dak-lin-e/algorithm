# PROGRAMMERS #120861 · 캐릭터의 좌표
# https://school.programmers.co.kr/learn/courses/30/lessons/120861
# Language: python

def solution(keyinput, board):
    answer=[0,0]
    for i in keyinput:
        if i == 'left':
            if answer[0] == -1*(board[0]//2) :
                pass
            else :
                answer[0]=answer[0]-1
        elif i == 'right':
            if board[0]//2 == answer[0] :
                pass
            else :
                answer[0]=answer[0]+1
        elif i == 'up':
            if board[1]//2 == answer[1] :
                pass
            else:
                answer[1]=answer[1]+1
        elif i == 'down':
            if answer[1] == -1*(board[1]//2) :
                pass
            else:
                answer[1]=answer[1]-1
        
    return answer