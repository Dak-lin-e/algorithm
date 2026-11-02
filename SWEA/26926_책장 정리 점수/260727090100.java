// SWEA #26926 · 책장 정리 점수
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCW6HYXHBIQj
// Language: JAVA
// Execution Time: 88 ms
// Memory: 26240 KB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
        
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int n = Integer.parseInt(br.readLine().trim());
            int[] board= new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i< n; i++){
            board[i]=Integer.parseInt(st.nextToken());
            
            }
            int max1=0;
              for(int i=0;i<n-1;i++){
                  int max=0;
                   for(int j=i+1; j<n;j++){
                       if (board[i]>board[j]){
                       max+=1;
                       }
                   }
                  if (max>max1){
                  max1=max;
                  }
              }
            System.out.printf("#%d %d%n",test_case,max1);
		}
	}
}