// SWEA #27024 · 줄 서기 앞뒤 삽입
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87xb8K9IPHBIOQ
// Language: JAVA
// Execution Time: 124 ms
// Memory: 29824 KB

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
            Deque<Integer> seq = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
		        StringTokenizer st = new StringTokenizer(br.readLine());
                int [] n1 = new int[2];
                for(int j=0; j<2; j++){
                    n1[j]=Integer.parseInt(st.nextToken());
                }
                if(n1[0]==1){
                    seq.addFirst(n1[1]);
            
                }
                else{
                    seq.add(n1[1]);
                }
                }
            
            System.out.print("#"+test_case+" ");
			for(int num:seq){
                System.out.print(num+" ");
            }
            System.out.println();
		}
	}
}
