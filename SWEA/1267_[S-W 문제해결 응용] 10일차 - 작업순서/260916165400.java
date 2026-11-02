// SWEA #1267 · [S/W 문제해결 응용] 10일차 - 작업순서
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18TrIqIwUCFAZN
// Language: JAVA
// Execution Time: 95 ms
// Memory: 28288 KB

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      
        for (int test_case = 1; test_case <= 10; test_case++) {
            String line = br.readLine();
            if (line == null) break;
            
            StringTokenizer st = new StringTokenizer(line);
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수
            
            // 1. 인접 리스트와 진입차수(In-degree) 배열 초기화
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }
            int[] inDegree = new int[V + 1];
            
            // 2. 간선 정보 입력받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                
                adj.get(from).add(to); // from -> to 방향 설정
                inDegree[to]++;        // to로 들어오는 간선 개수 증가
            }
            
            // 3. 진입차수가 0인 노드를 큐(Queue)에 삽입
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= V; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }
            
            // 4. 위상 정렬 수행 및 결과 저장
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
            
            while (!q.isEmpty()) {
                int curr = q.poll();
                sb.append(curr).append(" ");
                
                // 현재 정점과 연결된 다음 정점들의 진입차수를 1씩 감소
                for (int next : adj.get(curr)) {
                    inDegree[next]--;
                    // 진입차수가 0이 되었다는 것은 선행 정점이 모두 처리되었음을 의미
                    if (inDegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
            
            System.out.println(sb.toString());
        }
    }
}
