// SWEA #26941 · 토너먼트 점수 합산
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpHCaHcHHBIQj
// Language: JAVA
// Execution Time: 75 ms
// Memory: 25728 KB

import java.util.*;
import java.io.*;

class Solution
{
    // 아래에서 위로(Bottom-Up) 점수를 채워나가는 재귀 함수
    static int getScore(int node, int[] scores, int N) {
        // 만약 자식 노드 번호가 N을 넘어가면 존재하지 않는 칸이므로 0 리턴
        if (node > N) {
            return 0;
        }
        
        // 만약 이 칸에 이미 점수가 입력되어 있다면(선수 자리 등) 그 점수를 그대로 사용
        if (scores[node] != 0) {
            return scores[node];
        }
        
        // 자식이 없는 리프 노드인데 점수가 입력되지 않았다면 0
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;
        
        if (leftChild > N && rightChild > N) {
            return 0;
        }
        
        // 두 아래 칸(자식)의 점수를 합산하여 현재 칸의 점수로 저장 후 리턴
        scores[node] = getScore(leftChild, scores, N) + getScore(rightChild, scores, N);
        return scores[node];
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 전체 칸 개수
            int M = Integer.parseInt(st.nextToken()); // 선수 자리 개수
            int L = Integer.parseInt(st.nextToken()); // 점수를 알고 싶은 칸 번호
            
            // 1번부터 N번까지의 칸 점수를 저장할 배열
            int[] scores = new int[N + 1];
            
            // 선수 자리 정보 입력
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int nodeNo = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                scores[nodeNo] = score;
            }
            
            // L번 칸의 점수 계산 (전체 트리를 채우며 L번의 점수 도출)
            int answer = getScore(L, scores, N);
            
            System.out.println("#" + test_case + " " + answer);
        }
    }
}