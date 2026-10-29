# PROGRAMMERS #120866 · 안전지대
# https://school.programmers.co.kr/learn/courses/30/lessons/120866
# Language: python

def solution(board):
    answer = 0
    for i,j in enumerate(board):
        for m,n in enumerate(j):
            if n ==1:
                for k in range(-1,2):
                    for l in range(-1,2):
                        
                        if 0 > i+k or i+k >= len(board):
                            pass
                        elif  m+l >= len(board) or m+l <0:
                            pass
                        
                        else:
                            
                            if board[i+k][m+l]==1:
                                pass
                            else: 
                                board[i+k][m+l]='x'
            else:
                pass
            
            
            
    for i,j in enumerate(board):
        for m,n in enumerate(j):
            if n=='x':
                answer+=1
            elif n==1 : 
                answer+=1
            else:
                pass
                            
    return (len(board))*(len(board)) - answer