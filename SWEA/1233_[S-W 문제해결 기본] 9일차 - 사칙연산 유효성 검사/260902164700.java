// SWEA #1233 · [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
// Language: JAVA
// Execution Time: 87 ms
// Memory: 26496 KB

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 총 10개의 테스트 케이스
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            
            boolean isValid = true;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int nodeNum = Integer.parseInt(st.nextToken());
                char val = st.nextToken().charAt(0);
                
                // 완전 이진 트리 성질에 따라:
                // N / 2보다 크면 자식이 없는 리프 노드
                // N / 2 이하면 자식이 있는 내부 노드
                if (nodeNum <= N / 2) {
                    // 내부 노드인데 숫자가 들어있다면 유효하지 않음
                    if (val >= '0' && val <= '9') {
                        isValid = false;
                    }
                } else {
                    // 리프 노드인데 연산자(숫자가 아님)가 들어있다면 유효하지 않음
                    if (!(val >= '0' && val <= '9')) {
                        isValid = false;
                    }
                }
            }
            
            int result = isValid ? 1 : 0;
            System.out.println("#" + test_case + " " + result);
        }
    }
}