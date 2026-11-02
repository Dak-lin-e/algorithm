// SWEA #26925 · 걷기 앱 기간 활동량 차이
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCD6HYHHBIQj
// Language: JAVA
// Execution Time: 86 ms
// Memory: 26624 KB

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
			int[] mn = new int[2];
            for(int i=0; i<2; i++){
            mn[i]=Integer.parseInt(st.nextToken());
            }
            
            int [] board = new int[mn[0]];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0; j<mn[0];j++){
            	board[j]=Integer.parseInt(st1.nextToken());
            }
            ArrayList<Integer> answer = new ArrayList<>();
            int len=mn[0]-mn[1]+1;
            for(int k=0; k < len; k++){
            int total=0;
                for(int h=0; h<mn[1];h++){
                	total += board[k+h];
                }              
              answer.add(total);
            }
            int max=0,min=answer.get(0);
            for(int e : answer){
                if (e>max){
                max=e;
                }
                if(e<min){
                min=e;
                }
            }
            
            System.out.printf("#%d %d%n",test_case,(max-min));
		}
	}
}