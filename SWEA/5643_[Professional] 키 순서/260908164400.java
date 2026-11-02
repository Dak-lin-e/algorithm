// SWEA #5643 · [Professional] 키 순서
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
// Language: JAVA
// Execution Time: 2018 ms
// Memory: 104452 KB

import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<ArrayList<Integer>> forwardTree;  // 자신보다 큰 학생 방향 (u -> v)
    static ArrayList<ArrayList<Integer>> backwardTree; // 자신보다 작은 학생 방향 (v -> u)
    static int N; 

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String firstLine = br.readLine();
        if (firstLine == null) return;
        int T = Integer.parseInt(firstLine.trim());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());

            // 인접 리스트 초기화 (1번부터 N번까지 사용)
            forwardTree = new ArrayList<>();
            backwardTree = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                forwardTree.add(new ArrayList<>());
                backwardTree.add(new ArrayList<>());
            }

            // 간선 정보 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                forwardTree.get(u).add(v);  // u번이 v번보다 키가 작음 (u -> v)
                backwardTree.get(v).add(u); // v번이 u번보다 키가 큼 (v -> u)
            }

            int answer = 0;
            
            // 모든 학생(1번부터 N번까지)에 대해 순위를 확정할 수 있는지 확인
            for (int i = 1; i <= N; i++) {
                int biggerCount = bfs(i, forwardTree);   // 나보다 키가 큰 학생 수
                int smallerCount = bfs(i, backwardTree); // 나보다 키가 작은 학생 수

                // (나보다 큰 학생 수 + 나보다 작은 학생 수) == 전체 학생 수 - 1 이면 순위를 정확히 아는 것임
                if (biggerCount + smallerCount == N - 1) {
                    answer++;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    // BFS를 통해 연결된(도달 가능한) 노드의 개수를 세는 함수
    static int bfs(int start, ArrayList<ArrayList<Integer>> tree) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : tree.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}