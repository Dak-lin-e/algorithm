# PROGRAMMERS #76502 · 괄호 회전하기
# https://school.programmers.co.kr/learn/courses/30/lessons/76502
# Language: python

from collections import deque

def solve(s1):
    stack = []
    for char in s1:
        # 여는 괄호인 경우 스택에 삽입
        if char in ('{', '(', '['):
            stack.append(char)
        else:
            # 닫는 괄호인데 스택이 비어있거나 짝이 맞지 않으면 False
            if not stack:
                return False
            
            top = stack.pop()
            if char == '}' and top != '{':
                return False
            if char == ')' and top != '(':
                return False
            if char == ']' and top != '[':
                return False
                
    # 모든 검사 후 스택이 비어있어야 올바른 괄호
    return len(stack) == 0

def solution(s):
    answer = 0
    s1 = deque(s)
    
    for j in range(len(s1)):
        if j >= 1:
            re = s1.popleft()
            s1.append(re)
            
        if solve(s1):
            answer += 1
            
    return answer