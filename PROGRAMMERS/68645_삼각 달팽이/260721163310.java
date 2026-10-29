// PROGRAMMERS #68645 · 삼각 달팽이
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// Language: java

class Solution {
    public int[] solution(int n) {
        // 1. 전체 칸 수(total) 계산
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        
        // 2. 최종 결과로 반환할 1차원 배열 생성
        int[] answer = new int[total];
        
        // 3. 달팽이 이동을 위한 2차원 가상 판 (기존 로직 유지)
        int[][] board = new int[n][n];
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int x = 0, y = 0, k = 0;
        board[0][0] = 1;
        
        for (int i = 2; i <= total; i++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] != 0) {
                k = (k + 1) % 3;
                nx = x + dx[k];
                ny = y + dy[k];
            }
            
            board[nx][ny] = i;
            x = nx;
            y = ny;
        }
        
        // 4. 2차원 배열의 삼각형 모양 값을 1차원 배열(answer)에 순서대로 담기
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = board[i][j];
            }
        }
        
        return answer;
    }
}