// SWEA #1249 · [S/W 문제해결 응용] 4일차 - 보급로
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
// Language: Java
// Execution Time: 118 ms
// Memory: 29056 KB

import java.util.*;
import java.io.*;

// 1. PriorityQueue에서 비용 기준으로 정렬하기 위해 Comparable 인터페이스 구현
class Node implements Comparable<Node> {
    int x, y, cost;

    Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        // 비용이 작은 것이 먼저 오도록 오름차순 정렬
        return Integer.compare(this.cost, o.cost);
    }
}

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];
            int[][] minDist = new int[N][N]; // 각 좌표별 최소 비용을 기록할 배열

            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    minDist[i][j] = Integer.MAX_VALUE; // 최솟값 갱신을 위해 최대값으로 초기화
                }
            }

            // 2. 우선순위 큐(PriorityQueue) 선언
            PriorityQueue<Node> pq = new PriorityQueue<>();
            
            // 시작점 초기화
            pq.offer(new Node(0, 0, map[0][0]));
            minDist[0][0] = map[0][0];

            int answer = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                // 목적지(N-1, N-1)에 도착했다면 최소 비용 확정 후 종료
                if (curr.x == N - 1 && curr.y == N - 1) {
                    answer = curr.cost;
                    break;
                }

                // 현재 기록된 최소 비용보다 크다면 더 이상 탐색할 필요 없음 (가지치기)
                if (curr.cost > minDist[curr.x][curr.y]) {
                    continue;
                }

                // 4방향 탐색
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int nextCost = curr.cost + map[nx][ny];

                        // 기존에 기록된 최소 비용보다 더 적은 비용으로 갈 수 있는 경우에만 갱신
                        if (nextCost < minDist[nx][ny]) {
                            minDist[nx][ny] = nextCost;
                            pq.offer(new Node(nx, ny, nextCost));
                        }
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        
        System.out.print(sb);
    }
}