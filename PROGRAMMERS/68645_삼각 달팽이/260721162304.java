// PROGRAMMERS #68645 · 삼각 달팽이
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// Language: java

import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        
        int[][] board = new int[n][n]; // 각 행을 n크기로 잡아도 삼각형 모양으로 쓸 수 있습니다.
        
        // 이동 방향: 아래로(1, 0), 오른쪽으로(0, 1), 왼쪽 위 대각선(-1, -1)
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        int x = 0, y = 0, k = 0;
        board[0][0] = 1;
        
        for (int i = 2; i <= total; i++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            // 범위를 벗어나거나 이미 숫자가 채워져 있는 경우 (0이 아닌 경우)
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] != 0) {
                k = (k + 1) % 3; // 방향 전환
                nx = x + dx[k];
                ny = y + dy[k];
            }
            
            board[nx][ny] = i;
            x = nx; // 현재 위치 갱신 필수!
            y = ny; // 현재 위치 갱신 필수!
        }
        
        // 삼각형 모양대로 리스트에 담기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer.add(board[i][j]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}