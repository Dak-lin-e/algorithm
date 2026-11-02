// SWEA #27019 · 진료 대기시간 최소 순서
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c1gqyEvHBITH
// Language: JAVA
// Execution Time: 98 ms
// Memory: 27392 KB

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
		{
		    int n = Integer.parseInt(br.readLine());
            StringTokenizer st =new StringTokenizer(br.readLine());
            int [] list1 = new int[n];
            for(int i=0; i<n; i++){
                list1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list1);
            
            int answer=0;
            int total=0;
            for(int i=1; i<n; i++){
                total += list1[i-1];
                answer+=total;
            }
            System.out.println("#"+test_case+" " + answer);
		}
	}
}
