// SWEA #26927 · 다트 최다 점수 집계
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCyaHYnHBIQj
// Language: JAVA
// Execution Time: 87 ms
// Memory: 25984 KB

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
		    int []board = new int[n];
            String s1 = br.readLine();
            for(int i=0; i<s1.length() ; i++){
            board[i] =s1.charAt(i)-'0';
            }
             HashMap<Integer,Integer> map1 = new HashMap<>();

            for(int i=0; i<board.length; i++){
                if(map1.containsKey(board[i])){
                    map1.put(board[i], map1.get(board[i]) + 1);               }
                else{
                map1.put(board[i],1);
                }
            }
            
            int max=0,key=0;
            for(int i =0; i< board.length; i++){
            if(map1.get(board[i])>max){
                max=map1.get(board[i]);
                key= board[i];
            }
            else if (map1.get(board[i])==max){
                 if(board[i]>key){
                max=map1.get(board[i]);
                key= board[i];}
            }
            }
            
         System.out.printf("#%d %d %d\n", test_case, key, max);        
        }
	}
}