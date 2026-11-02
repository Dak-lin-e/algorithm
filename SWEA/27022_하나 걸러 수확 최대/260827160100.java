// SWEA #27022 · 하나 걸러 수확 최대
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c2Z6yFnHBITH
// Language: JAVA
// Execution Time: 98 ms
// Memory: 27136 KB

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
            int trees[] = new int[N];
            
            // [수정] 데이터가 여러 줄에 나뉘어 들어올 수 있으므로 N개를 다 채울 때까지 안전하게 읽기
            int count = 0;
            while(count < N) {
                String line = br.readLine();
                if(line == null) break;
                line = line.trim();
                if(line.isEmpty()) continue;
                
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens() && count < N) {
                    trees[count++] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 나무가 1그루뿐인 경우 예외 처리
            if(N == 1){
                System.out.println("#" + test_case + " " + trees[0]);
                continue;
            }

            // DP 테이블 선언 및 초기화
            int[] dp = new int[N];
            dp[0] = trees[0];
            dp[1] = Math.max(trees[0], trees[1]);

            // DP 점화식 적용 (인접한 나무는 함께 수확 불가)
            for(int i = 2; i < N; i++){
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + trees[i]);
            }

            // 결과 출력
            System.out.println("#" + test_case + " " + dp[N - 1]);
        }
    }
}