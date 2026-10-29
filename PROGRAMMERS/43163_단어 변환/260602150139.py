# PROGRAMMERS #43163 · 단어 변환
# https://school.programmers.co.kr/learn/courses/30/lessons/43163
# Language: python

from collections import deque

# 한 글자만 다른지 확인하는 함수 (작성하신 함수 그대로 활용!)
def differ(word1, word2):
    count = 0
    for i in range(len(word1)):
        if word1[i] != word2[i]:
            count += 1
        if count == 2:
            return False
    return count == 1

def solution(begin, target, words):
    # 1. 예외 처리 수정: target이 words에 없으면 변환 불가능하므로 0 리턴
    if target not in words:
        return 0
        
    # 2. BFS를 위한 큐(queue) 생성
    # 큐에는 (현재 단어, 지금까지의 변환 횟수)를 튜플 형태로 같이 묶어서 저장합니다.
    queue = deque([(begin, 0)])
    
    # 방문한 단어를 체크할 셋(Set). 리스트보다 탐색 속도가 훨씬 빠릅니다.
    visited = set([begin])
    
    # 3. 큐가 빌 때까지 탐색 시작
    while queue:
        current_word, steps = queue.popleft()
        
        # 목표 단어에 도달했다면? BFS 특성상 이게 무조건 '최단 거리'이므로 즉시 리턴!
        if current_word == target:
            return steps
            
        # 단어 목록을 돌며 다음으로 변환 가능한 단어 찾기
        for word in words:
            if word not in visited and differ(current_word, word):
                visited.add(word)  # 방문 체크
                queue.append((word, steps + 1))  # 큐에 넣을 때 변환 횟수 +1
                
    # 큐가 다 빌 때까지 target을 못 만났다면 변환 불가하므로 0 리턴
    return 0