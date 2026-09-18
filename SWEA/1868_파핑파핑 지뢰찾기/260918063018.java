import java.util.*;

import java.io.*;

class Solution {
    static int N;
    static char[][] board;
    static int[][] mineCount;
    static boolean[][] visited;
    
    // 8방향 (상, 하, 좌, 우, 대각선 4개)
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());
            board = new char[N][N];
            mineCount = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            // 1. 각 칸 주변의 지뢰 개수 미리 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '*') {
                        mineCount[i][j] = -1; // 지뢰인 칸
                        continue;
                    }
                    
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (board[nx][ny] == '*') {
                                count++;
                            }
                        }
                    }
                    mineCount[i][j] = count;
                }
            }

            int clicks = 0;

            // 2. 주변 지뢰가 0인 칸들을 먼저 전부 연쇄 오픈 (BFS)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mineCount[i][j] == 0 && !visited[i][j] && board[i][j] != '*') {
                        clicks++;
                        bfs(i, j);
                    }
                }
            }

            // 3. 연쇄 오픈으로 열리지 않은 남은 숫자 칸들 개수 추가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 지뢰가 아니고, 방문(클릭)되지 않은 칸이라면 따로 한 번씩 더 클릭해야 함
                    if (board[i][j] != '*' && !visited[i][j]) {
                        clicks++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + clicks);
        }
    }

    // 0인 칸을 만났을 때 8방향으로 퍼져나가며 연쇄적으로 여는 BFS 함수
    static void bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            // 현재 칸이 0이라면 주변 8방향을 모두 열어줌
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && board[nx][ny] != '*') {
                        visited[nx][ny] = true;
                        // 만약 연쇄적으로 열린 칸 중 또 0이 있다면 그 칸을 기준으로 계속 퍼져나감
                        if (mineCount[nx][ny] == 0) {
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}