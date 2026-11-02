// SWEA #3260 · 두 수의 덧셈
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBC1lOad9IDFAWr
// Language: JAVA
// Execution Time: 101 ms
// Memory: 27520 KB


import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution
{
	public static void main(String args[]) throws Exception
	{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
		     BigInteger a =new BigInteger(st.nextToken());
             BigInteger b =new BigInteger(st.nextToken());
            
            System.out.println("#" + test_case+" " + a.add(b));
		}
	}
}