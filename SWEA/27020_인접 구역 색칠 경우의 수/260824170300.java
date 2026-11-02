// SWEA #27020 · 인접 구역 색칠 경우의 수
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c1z6yFHHBITH
// Language: JAVA
// Execution Time: 102 ms
// Memory: 31036 KB

import java.util.*;
import java.io.*;

class Solution {
    static int N, M, K;
    static ArrayList<ArrayList<Integer>> links;
    static int[] colors; // 각 구역에 칠해진 색 번호 (1번 ~ N번)
    static int answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 인접 리스트 초기화
            links = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                links.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                links.get(u).add(v);
                links.get(v).add(u);
            }

            answer = 0;
            colors = new int[N + 1]; // 0은 색을 칠하지 않은 상태

            // 1번 구역부터 백트래킹 탐색 시작
            dfs(1);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    // 구역을 하나씩 채워나가는 DFS 함수
    static void target(int idx) { // (함수명은 통상 dfs로 사용)
    }

    static void dfs(int node) {
        // 모든 구역을 다 칠했다면 경우의 수 1 증가 후 리턴
        if (node > N) {
            answer++;
            return;
        }

        // 1번 색부터 K번 색까지 시도해봄
        for (int c = 1; c <= K; c++) {
            if (isAvailable(node, c)) {
                colors[node] = c;     // 색 칠하기
                dfs(node + 1);        // 다음 구역으로 이동
                colors[node] = 0;     // 원상복구 (백트래킹)
            }
        }
    }

    // 현재 구역(node)에 색(c)을 칠할 수 있는지 검사
    static boolean isAvailable(int node, int c) {
        // 나와 인접한 구역들을 확인
        for (int neighbor : links.get(node)) {
            // 인접한 구역에 이미 나와 같은 색이 칠해져 있다면 불가능
            if (colors[neighbor] == c) {
                return false;
            }
        }
        return true;
    }
}