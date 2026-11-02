// SWEA #5643 · [Professional] 키 순서
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
// Language: JAVA
// Execution Time: 1480 ms
// Memory: 99500 KB

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String firstLine = br.readLine();
        if (firstLine == null) return;
        int T = Integer.parseInt(firstLine.trim());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());
            
            boolean[][] connected = new boolean[N + 1][N + 1];
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                connected[u][v] = true; // u번 학생이 v번 학생보다 키가 작음
            }
            
            // 플로이드-워샬 알고리즘: 거쳐서 갈 수 있는 관계가 있다면 모두 연결
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (connected[i][k] && connected[k][j]) {
                            connected[i][j] = true;
                        }
                    }
                }
            }
            
            int answer = 0;
            
            // 모든 학생에 대해 자신과의 키 관계를 알 수 있는 학생 수 세기
            for (int i = 1; i <= N; i++) {
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    // i가 j보다 작거나, j가 i보다 크다는 것을 알 수 있다면 비교 가능한 사이임
                    if (connected[i][j] || connected[j][i]) {
                        count++;
                    }
                }
                
                // 나와 키를 비교할 수 있는 사람이 자신을 제외한 모두(N - 1명)라면 순위를 정확히 아는 것임
                if (count == N - 1) {
                    answer++;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
        }
    }
}