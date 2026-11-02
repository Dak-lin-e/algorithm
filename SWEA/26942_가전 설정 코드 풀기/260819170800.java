// SWEA #26942 · 가전 설정 코드 풀기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpHWKHcXHBIQj
// Language: JAVA
// Execution Time: 135 ms
// Memory: 32120 KB

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
            StringTokenizer st = new StringTokenizer(br.readLine());

            String[] list2 = new String[Integer.parseInt(st.nextToken())];
            
            list2=st.nextToken().split("");
            
            StringBuilder sb = new StringBuilder() ;
            for(int i=0; i<list2.length; i++){
                int temp =Integer.parseInt(list2[i],16);
                int width = 4; 
                // 고정할 자릿수 (예: 8자리 bit)

// 1단계: 2진수 변환 후 8자리 빈칸 확보 -> "     101"
// 2단계: 빈칸(' ')을 '0'으로 치환 -> "00000101"
               String bin = String.format("%" + width + "s", Integer.toBinaryString(temp)).replace(' ', '0');                
               sb.append(bin);
            }  
            System.out.println("#"+test_case+ " " + sb);
		}
	}
}