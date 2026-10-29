# PROGRAMMERS #181932 · 코드 처리하기
# https://school.programmers.co.kr/learn/courses/30/lessons/181932
# Language: python

def solution(code):
    mode = 0
    ret = []

    for idx, char in enumerate(code):
        if char == '1':
            mode = 1 - mode  # mode 전환
        else:
            if mode == 0 and idx % 2 == 0:
                ret.append(char)
            elif mode == 1 and idx % 2 == 1:
                ret.append(char)

    return ''.join(ret) if ret else "EMPTY"
