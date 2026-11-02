// SWEA #26923 · 일일 방문자 수 변동 폭
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6woi46HXnHBIQj
// Language: JAVA
// Execution Time: 119 ms
// Memory: 32256 KB

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static int solve(int n, int[] board){
        int max = board[0], min = board[0]; // min 초기화도 board[0]으로 안전하게 맞추기
        
        for(int i = 0; i < n; i++){
            if(board[i] > max){
                max = board[i];
            }
        }
        
        for(int i = 1; i < n; i++){
            if(board[i] < min){
                min = board[i];
            }
        }    
        return (max - min);
    }
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] board = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < n; i++){
                board[i] = Integer.parseInt(st.nextToken());
            }
            
            int result = solve(n, board);    
            
            // 수정: println 대신 printf 사용 또는 문자열 연결 사용
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}