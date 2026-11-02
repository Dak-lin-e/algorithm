// SWEA #4012 · [모의 SW 역량테스트] 요리사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
// Language: JAVA
// Execution Time: 283 ms
// Memory: 27864 KB

import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int minDiff;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }     
            }

            visited = new boolean[N];
            minDiff = Integer.MAX_VALUE;

            // 백트래킹으로 N/2개 고르기 (0번 식재료부터 시작, 개수는 0개 선택함)
            combination(0, 0);

            System.out.println("#" + test_case + " " + minDiff);
        }
    }

    // DFS 조합 함수: idx는 현재 확인할 식재료 번호, count는 고른 개수
    static void combination(int idx, int count) {
        // N / 2개를 다 골랐다면 A 음식과 B 음식의 맛 차이 계산
        if (count == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // A 음식과 B 음식을 나누어 맛의 차이를 구하는 함수
    static void calculateDiff() {
        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                
                // 둘 다 A 음식에 속한 경우
                if (visited[i] && visited[j]) {
                    aScore += board[i][j];
                }
                // 둘 다 B 음식에 속한 경우 (!visited[i] && !visited[j])
                else if (!visited[i] && !visited[j]) {
                    bScore += board[i][j];
                }
            }
        }

        int diff = Math.abs(aScore - bScore);
        minDiff = Math.min(minDiff, diff);
    }
}