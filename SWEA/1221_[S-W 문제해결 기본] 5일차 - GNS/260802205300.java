// SWEA #1221 · [S/W 문제해결 기본] 5일차 - GNS
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
// Language: JAVA
// Execution Time: 158 ms
// Memory: 39360 KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        // GNS 문제의 정해진 순서 배열
        String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            ArrayList<String> list1 = new ArrayList<>();
            for(int i = 0; i < 2; i++){
                list1.add(st.nextToken());
            }
            
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            
            ArrayList<String> list2 = new ArrayList<>();
            int t = Integer.parseInt(list1.get(1)); // 데이터 개수
            
            for(int i = 0; i < t; i++){
                list2.add(st1.nextToken());
            }
            
            // 빈도수 체크를 위한 HashMap
            HashMap<String, Integer> board = new HashMap<>();
            for(int j = 0; j < list2.size(); j++){
                String key = list2.get(j);
                
                if(board.containsKey(key)){
                    board.put(key, board.get(key) + 1);
                }
                else {
                    board.put(key, 1);
                }
            }
            
            // [추가된 부분] 정해진 순서와 카운트 개수대로 결과 조합하기
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < numbers.length; i++) {
                String target = numbers[i];
                
                // 만약 해당 문자가 맵에 존재한다면 저장된 개수만큼 가져옴
                if(board.containsKey(target)) {
                    int count = board.get(target);
                    for(int k = 0; k < count; k++) {
                        sb.append(target).append(" ");
                    }
                }
            }
            
            // 최종 출력 (#테스트케이스번호 정렬된결과)
            System.out.println(list1.get(0));
            System.out.println(sb.toString().trim());
        }
    }
}