// SWEA #26931 · 컨베이어 벨트 상자 정리
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpD-qHZnHBIQj
// Language: JAVA
// Execution Time: 106 ms
// Memory: 27904 KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		     String s1 = br.readLine();
             String[] s2 = s1.split("");
            Stack<String> stack = new Stack<>();
             for(int i =0; i < s2.length; i++){
                 if(stack.empty() || !stack.peek().equals(s2[i]) ){
                 stack.push(s2[i]);
                 }
                 else if(stack.peek().equals (s2[i])){
                 stack.pop();
                 }
             }
           System.out.println("#"+test_case+" "+stack.size());
		}
	}
}