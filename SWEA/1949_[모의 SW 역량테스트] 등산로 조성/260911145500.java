// SWEA #1949 · [모의 SW 역량테스트] 등산로 조성
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
// Language: JAVA
// Execution Time: 84 ms
// Memory: 25344 KB

import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int N, K;
    static int max_height, answer;
    
    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        // BufferedReader 하나로 통일하여 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            max_height = 0;
            answer = 0;

            // 1. 전체 지도를 입력받으며 '가장 높은 봉우리'의 높이를 먼저 찾습니다.
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > max_height) {
                        max_height = map[i][j];
                    }
                }
            }

            // 2. 가장 높은 봉우리(들)에서 각각 DFS 탐색을 시작합니다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max_height) {
                        visited[i][j] = true;
                        // (x, y, 현재 등산로 길이, 공사 기회 사용 여부)
                        dfs(i, j, 1, false);
                        visited[i][j] = false; // 백트래킹
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void dfs(int x, int y, int length, boolean usedChance) {
        // 매번 가장 긴 등산로 길이를 갱신합니다.
        answer = Math.max(answer, length);

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위를 벗어나거나 이미 방문한 곳이면 건너뜁니다.
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

            // Case 1: 다음 위치가 현재 위치보다 낮아서 그냥 이동 가능한 경우
            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                dfs(nx, ny, length + 1, usedChance);
                visited[nx][ny] = false; // 백트래킹
            }
            // Case 2: 다음 위치가 같거나 높지만, 아직 공사 기회가 남아있는 경우
            else if (!usedChance) {
                // 현재 높이보다 '딱 1만큼만 작게' 만들 수 있는지 확인합니다 (가장 유망한 공사 방식)
                int diff = map[nx][ny] - map[x][y];
                if (diff < K) { 
                    int originalHeight = map[nx][ny]; // 원본 높이 저장
                    
                    visited[nx][ny] = true;
                    map[nx][ny] = map[x][y] - 1; // 현재 높이보다 1 낮게 깎음
                    
                    dfs(nx, ny, length + 1, true); // 찬스 사용 처리 후 이동
                    
                    map[nx][ny] = originalHeight; // 깎았던 지형 원상복구 (백트래킹)
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
