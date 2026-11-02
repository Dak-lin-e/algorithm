// SWEA #26949 · 전기 자전거의 최소 배터리 배달 경로
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpJdKHeHHBIQj
// Language: JAVA
// Execution Time: 141 ms
// Memory: 34688 KB

import java.util.*;
import java.io.*;

class Solution
{
    // 1. 우선순위 큐를 쓰기 위해 Comparable 인터페이스 구현
    static class node implements Comparable<node>{
        int x, y, dist;
        node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(node o) {
            return Integer.compare(this.dist, o.dist); // 배터리 소비량이 적은 것이 우선
        }
    } 

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int board[][] = new int[N][N];
            
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());                    
                for(int j=0; j<N; j++){
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            
            // 2. 최소 비용을 기록할 배열 (무한대로 초기화)
            int[][] minCost = new int[N][N];
            for(int i = 0; i < N; i++){
                Arrays.fill(minCost[i], Integer.MAX_VALUE);
            }

            // 3. 일반 큐 대신 PriorityQueue 사용
            PriorityQueue<node> q = new PriorityQueue<>();
            q.offer(new node(0, 0, 0));
            minCost[0][0] = 0;
            
            int answer = 0;
            
            // 4. 상, 하, 좌, 우 4방향 탐색
            int dx[] = {1, 0, -1, 0};
            int dy[] = {0, 1, 0, -1};
            
            while(!q.isEmpty()){
                node q1 = q.poll();
                
                // 목적지(오른쪽 아래)에 도착했다면 그것이 최단 경로! 바로 탈출
                if(q1.x == N-1 && q1.y == N-1){
                    answer = q1.dist;
                    break;
                }
                
            
                
                for(int i = 0; i < 4; i++){
                    int nx = q1.x + dx[i];
                    int ny = q1.y + dy[i];
                    
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                        // 배터리 소모량 계산: 기본 1 + 높이가 높아지면 차이만큼 추가
                        int heightDiff = board[nx][ny] - board[q1.x][q1.y];
                        int moveCost = 1 + (heightDiff > 0 ? heightDiff : 0);
                        int nextDist = q1.dist + moveCost;
                        
                        // 더 적은 배터리로 갈 수 있다면 최솟값 갱신 후 큐에 삽입
                        if(nextDist < minCost[nx][ny]){
                            minCost[nx][ny] = nextDist;
                            q.offer(new node(nx, ny, nextDist));
                        }
                    }       
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
        }
    }
}