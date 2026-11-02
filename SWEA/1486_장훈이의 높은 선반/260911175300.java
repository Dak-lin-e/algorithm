// SWEA #1486 · 장훈이의 높은 선반
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw
// Language: JAVA
// Execution Time: 142 ms
// Memory: 25984 KB

import java.util.*;
import java.io.*;

class Solution {
    static int N, B;
    static int[] height;
    static int minDiff;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            height = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            minDiff = Integer.MAX_VALUE;

            // DFS로 모든 부분집합(조합) 탐색 시작
            // 0번 인덱스부터 시작, 현재 탑의 높이는 0
            dfs(0, 0);

            // 문제에서 요구하는 것은 "탑의 높이 - B"의 최솟값
            System.out.println("#" + test_case + " " + minDiff);
        }
    }

    static void dfs(int idx, int currentHeight) {
        // 이미 현재 탑의 높이가 B 이상이고, 기존에 찾은 최소 차이보다 크거나 같다면
        // 더 높여봐야 의미가 없으므로 가지치기 (Pruning)
        if (currentHeight - B >= minDiff) {
            return;
        }

        // 현재 탑의 높이가 B 이상이라면 차이값 갱신
        if (currentHeight >= B) {
            minDiff = Math.min(minDiff, currentHeight - B);
            return; // B를 넘었으므로 더 이상 재료를 안 더해도 됨
        }

        // 모든 점원을 다 확인했으면 종료
        if (idx == N) {
            return;
        }

        // 1. 현재 점원을 탑에 포함하는 경우
        dfs(idx + 1, currentHeight + height[idx]);

        // 2. 현재 점원을 탑에 포함하지 않는 경우
        dfs(idx + 1, currentHeight);
    }
}