// SWEA #26937 · 창고 운반차의 최단 운행
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpF0KHbHHBIQj
// Language: JAVA
// Execution Time: 118 ms
// Memory: 32100 KB

import java.util.*;
import java.io.*;

class Solution {
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] board = new int[N][N];
            
            int startX = -1, startY = -1;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j) - '0';
                    if (board[i][j] == 2) { // 출발지(거치대)
                        startX = i;
                        startY = j;
                    }
                }
            }

            boolean[][] visited = new boolean[N][N];
            Queue<Point> q = new LinkedList<>();
            
            q.offer(new Point(startX, startY, 0));
            visited[startX][startY] = true;

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            
            int answer = 0; // 도달하지 못하면 0
            
            while (!q.isEmpty()) {
                Point p = q.poll();

                // 적재 게이트(3)에 도착한 경우
                if (board[p.x][p.y] == 3) {
                    // 출발 칸과 도착 칸을 제외하므로, 총 이동 거리에서 1을 뺍니다.
                    // (예: 총 6칸 움직였으면 거쳐 간 칸은 5개)
                    answer = p.dist - 1; 
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (board[nx][ny] != 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny, p.dist + 1));
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}