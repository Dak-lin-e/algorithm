// SWEA #2112 · [모의 SW 역량테스트] 보호 필름
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
// Language: JAVA
// Execution Time: 411 ms
// Memory: 95176 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int D, W, K;
    static int[][] film;

    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];

            for (int i = 0; i < D; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 처음부터 조건을 만족하는 경우
            if (check()) {
                answer = 0;
            } else {
                answer = K;

                dfs(0, 0);
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }

    // row번째 행부터 약품 투입 여부를 결정
    static void dfs(int row, int count) {

        // 이미 최솟값을 찾았다면 더 탐색할 필요 없음
        if (count >= answer) {
            return;
        }

        // 모든 행을 처리했다면 검사
        if (row == D) {

            if (check()) {
                answer = Math.min(answer, count);
            }

            return;
        }

        // 1. 현재 행을 건드리지 않음
        dfs(row + 1, count);

        // 현재 행 백업
        int[] backup = film[row].clone();

        // 2. 현재 행을 전부 0으로 변경
        Arrays.fill(film[row], 0);

        dfs(row + 1, count + 1);

        // 원상복구
        film[row] = backup.clone();

        // 3. 현재 행을 전부 1로 변경
        Arrays.fill(film[row], 1);

        dfs(row + 1, count + 1);

        // 원상복구
        film[row] = backup;
    }

    // 모든 열이 K개의 연속 조건을 만족하는지 검사
    static boolean check() {

        for (int col = 0; col < W; col++) {

            int count = 1;
            boolean pass = false;

            for (int row = 1; row < D; row++) {

                if (film[row][col] == film[row - 1][col]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= K) {
                    pass = true;
                    break;
                }
            }

            if (!pass) {
                return false;
            }
        }

        return true;
    }
}