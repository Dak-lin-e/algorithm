# PROGRAMMERS #43164 · 여행경로
# https://school.programmers.co.kr/learn/courses/30/lessons/43164
# Language: python

def solution(tickets):
    # 1. 알파벳 순서가 앞서는 경로를 먼저 찾기 위해 티켓 전체를 미리 정렬합니다.
    # 이렇게 하면 DFS 특성상 '가장 먼저 성공한 경로'가 무조건 알파벳 순 정답이 됩니다.
    tickets.sort(key=lambda x: (x[0], x[1]))
    
    # 각 티켓의 사용 여부를 체크할 배열 (동일한 티켓이 여러 장 있을 수 있으므로 인덱스로 관리)
    used = [False] * len(tickets)
    
    # 최종 경로를 담을 리스트 (시작은 항상 ICN)
    answer = ["ICN"]
    
    def dfs(current_airport):
        # Base Case: 모든 티켓을 다 사용했다면 정답을 찾은 것이므로 True 반환
        if len(answer) == len(tickets) + 1:
            return True
            
        for i, ticket in enumerate(tickets):
            # 아직 안 쓴 티켓이고, 현재 공항에서 출발하는 티켓이라면
            if not used[i] and ticket[0] == current_airport:
                
                # 1. 티켓 사용 처리 (Action)
                used[i] = True
                answer.append(ticket[1])
                
                # 2. 다음 공항으로 전진 (재귀 호출)
                # 만약 이 길의 끝에 정답이 있었다면 더 이상 탐색하지 않고 쭉 True를 리턴하며 탈출!
                if dfs(ticket[1]):
                    return True
                
                # 3. 막다른 길이었다면 원상 복구 (Backtracking) - 아주 중요!
                used[i] = False
                answer.pop()
                
        return False

    # ICN 공항에서 출발하며 DFS 시작
    dfs("ICN")
    return answer