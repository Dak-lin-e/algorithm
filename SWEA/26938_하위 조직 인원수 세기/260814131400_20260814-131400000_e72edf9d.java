// SWEA #26938 · 하위 조직 인원수 세기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpGHaHbXHBIQj
// Language: JAVA
// Execution Time: 112 ms
// Memory: 28416 KB

import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		    int [] board = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<2; i++){
                board[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
		    int [] web = new int[board[0]*2];
            for(int i=0; i<board[0]*2; i++){
                web[i] = Integer.parseInt(st.nextToken());
            }
            
            int answer =1;
            ArrayList<Integer> leaf = new ArrayList<>();
            leaf.add(board[1]);
            for(int i=0; i<web.length; i++){
                
                if(i%2==0 && web[i+1]==0){
                }
                else {
                if (i%2==0 && leaf.contains(web[i])){
                    leaf.add(web[i+1]);
                    answer+=1;
                }
                }
            }
            System.out.println("#"+test_case + " "+answer);
		}
	}
}