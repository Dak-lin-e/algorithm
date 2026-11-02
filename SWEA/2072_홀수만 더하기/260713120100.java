// SWEA #2072 · 홀수만 더하기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq
// Language: JAVA
// Execution Time: 70 ms
// Memory: 25216 KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수 T 입력
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            
            // 10개의 수를 읽으며 홀수인지 판별
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 != 0) {
                    sum += num;
                }
            }
            
            // 결과 출력
            System.out.println("#" + t + " " + sum);
        }
    }
}