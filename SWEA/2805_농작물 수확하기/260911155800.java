// SWEA #2805 · 농작물 수확하기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
// Language: JAVA
// Execution Time: 89 ms
// Memory: 27264 KB


import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        // Scanner를 없애고 BufferedReader 하나로만 입력을 처리합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= T; test_case++)
		{
            int answer=0;
            int N = Integer.parseInt(br.readLine());
		    int farm[][] = new int[N][N];
            for(int i =0; i<N; i++){
                String line = br.readLine();
                for(int j =0; j<N; j++){
                    farm[i][j] = line.charAt(j)-'0';
                }
            }
            
            int temp = N / 2;
            
            for(int i =0; i<=temp; i++){
                for(int j =temp-i; j<=temp+i; j++){
                    answer+= farm[i][j];
                }
            }

            for(int i =N-1 ; i > temp; i--){
                int y= (N-1)-i+temp;
                for(int j =i-temp; j<=y; j++){
                    answer+= farm[i][j];
                }
            }
            System.out.println("#"+test_case+" "+answer);
		
		}
	}
}