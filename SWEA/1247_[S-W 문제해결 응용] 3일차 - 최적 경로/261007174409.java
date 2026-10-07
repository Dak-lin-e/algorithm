// SWEA #1247 · [S/W 문제해결 응용] 3일차 - 최적 경로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
// Language: Java
// Execution Time: 236 ms
// Memory: 26860 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    
    static int[][] map;

    static boolean[] visited;

    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            map = new int[N + 2][2];

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            // 회사
            map[0][0] = Integer.parseInt(st.nextToken());
            map[0][1] = Integer.parseInt(st.nextToken());

            // 집
            map[1][0] = Integer.parseInt(st.nextToken());
            map[1][1] = Integer.parseInt(st.nextToken());

            // 고객
            for (int i = 2; i < N + 2; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 2];

            answer = Integer.MAX_VALUE;

            // 회사에서 시작
            dfs(0, 0, 0);

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }

    /**
     * current : 현재 위치
     * count   : 방문한 고객 수
     * distance: 현재까지 이동 거리
     */
    static void dfs(int current, int count, int distance) {

        // 현재 거리가 이미 정답보다 크다면
        // 더 탐색할 필요 없음
        if (distance >= answer) {
            return;
        }

        // 모든 고객을 방문했다면
        if (count == N) {

            // 마지막 고객 -> 집
            distance += getDistance(current, 1);

            answer = Math.min(answer, distance);

            return;
        }

        // 다음 고객 선택
        for (int next = 2; next < N + 2; next++) {

            if (visited[next]) {
                continue;
            }

            visited[next] = true;

            int move = getDistance(current, next);

            dfs(
                next,
                count + 1,
                distance + move
            );

            // 백트래킹
            visited[next] = false;
        }
    }

    // 맨해튼 거리
    static int getDistance(int a, int b) {

        return Math.abs(map[a][0] - map[b][0])
             + Math.abs(map[a][1] - map[b][1]);
    }
}