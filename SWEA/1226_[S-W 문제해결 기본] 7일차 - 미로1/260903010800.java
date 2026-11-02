// SWEA #1226 · [S/W 문제해결 기본] 7일차 - 미로1
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14vXUqAGMCFAYD
// Language: JAVA
// Execution Time: 72 ms
// Memory: 23040 KB

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		int []nx = {1,0,-1,0};
		int []ny = {0,1,0,-1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1 ; test_case <=10; test_case ++) {
			int K = Integer.parseInt(br.readLine());
			Deque<int[]> dq = new ArrayDeque<>();
			
			int [][] arr = new int[16][16];
			boolean [][]visited = new boolean[16][16];
			int N = 16;
			
			for(int i=0; i<N; i++) {
				String st = br.readLine();				
				for(int j=0; j<N; j++) {
					int m = st.charAt(j) - '0';
					arr[i][j] = m ;
					if (m == 2) {
						dq.addLast(new int[] {i,j});
						visited[i][j] = true;
					}
				}
			}
			
			boolean clear = false;
			while(!dq.isEmpty()) {
				int []start = dq.pollFirst(); //초기 값 뽑고 계산
				if(arr[start[0]][start[1]] == 3) {
					clear = true;
					break;
				}
				for(int i=0; i<4; i++) {
					int dx = start[0] +nx[i];
					int dy = start[1]+ny[i];
					if(dx < 0 || dx >=N || dy<0 || dy>=N) continue;
					if(visited[dx][dy] || arr[dx][dy] == 1) continue;
					
					visited[dx][dy] = true;
					dq.addLast(new int[] {dx, dy}); // 도달 다함
				}
				
			}
			
			if(clear) {
				System.out.println("#"+test_case+" "+1);
			}else {
				System.out.println("#"+test_case+" "+0);
			}
			
		}
		
		
	}
}
