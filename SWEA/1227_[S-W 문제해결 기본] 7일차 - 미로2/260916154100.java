// SWEA #1227 · [S/W 문제해결 기본] 7일차 - 미로2
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
// Language: JAVA
// Execution Time: 118 ms
// Memory: 31308 KB

import java.util.*;
import java.io.*;

class Solution {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 총 10개의 테스트 케이스
        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = Integer.parseInt(br.readLine().trim());
            
            board = new int[100][100];
            visited = new boolean[100][100];
            int startX = 0, startY = 0;

            // 100 x 100 미로 입력 (공백 없이 붙어서 들어오므로 문자열로 처리)
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = line.charAt(j) - '0';
                    if (board[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            // BFS 탐색 수행
            int result = bfs(startX, startY);

            System.out.println("#" + test_case + " " + result);
        }
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 도착점(3)에 도달한 경우
            if (board[x][y] == 3) {
                return 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                    // 벽(1)이 아니고 아직 방문하지 않은 길이라면
                    if (board[nx][ny] != 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return 0; // 도달할 수 없는 경우
    }
}