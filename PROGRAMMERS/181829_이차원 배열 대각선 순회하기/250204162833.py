# PROGRAMMERS #181829 · 이차원 배열 대각선 순회하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181829
# Language: python

def solution(board, k):
    answer = 0
    for i in range(len(board)):
        for j in range(len(board[i])):
            if i+j <= k :
                answer += board[i][j]
            else : 
                pass
    return answer