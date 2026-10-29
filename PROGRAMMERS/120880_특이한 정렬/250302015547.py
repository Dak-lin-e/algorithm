# PROGRAMMERS #120880 · 특이한 정렬
# https://school.programmers.co.kr/learn/courses/30/lessons/120880
# Language: python


def solution(numlist, n):       # 딕셔너리에 입력하는것으로 시작
    answer = {}
    for i in numlist:
        answer[i] = abs(i - n)
    answer = dict(sorted(answer.items(), key=lambda x: (x[1], -x[0])))
    return list(answer.keys())
    