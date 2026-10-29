# PROGRAMMERS #42626 · 더 맵게
# https://school.programmers.co.kr/learn/courses/30/lessons/42626
# Language: python

import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while(scoville[0] < K):
        if len(scoville)==1:
            return -1

        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)
        c= a+b*2
        heapq.heappush(scoville,c)
        answer+=1
    return answer