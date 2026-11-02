// SWEA #27022 · 하나 걸러 수확 최대
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c2Z6yFnHBITH
// Language: JAVA
// Execution Time: 93 ms
// Memory: 26880 KB

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int trees[] = new int[N];
            for(int i = 0; i < N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
            }
            
            // 나무가 1그루뿐인 경우 예외 처리
            if(N == 1){
                System.out.println("#" + test_case + " " + trees[0]);
                continue;
            }

            // DP 테이블 선언
            int[] dp = new int[N];
            dp[0] = trees[0];
            dp[1] = Math.max(trees[0], trees[1]);

            // 점화식 적용
            for(int i = 2; i < N; i++){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + trees[i]);
            }

            // 마지막 나무까지 고려했을 때의 최댓값 출력
            System.out.println("#" + test_case + " " + dp[N - 1]);
        }
    }
}