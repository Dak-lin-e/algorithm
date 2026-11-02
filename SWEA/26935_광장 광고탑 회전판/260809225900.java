// SWEA #26935 · 광장 광고탑 회전판
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpFLaHanHBIQj
// Language: JAVA
// Execution Time: 83 ms
// Memory: 25344 KB

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int [] nm = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<2; i++){
                 nm[i]= Integer.parseInt(st.nextToken());
            }
            int n = nm[1];
	        Queue<Integer> q1 = new LinkedList<>();
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i=0; i<nm[0]; i++){
                 q1.offer(Integer.parseInt(st1.nextToken()));
            }
            for(int i=0; i<n; i++){
            int a = q1.poll();
            q1.offer(a);
            }
            int result = q1.poll();
	        System.out.println("#" + test_case+ " "+result);
		}
	}
}