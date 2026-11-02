// SWEA #26934 · 회전 드럼식 커피 로스터
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpE4aHaXHBIQj
// Language: JAVA
// Execution Time: 86 ms
// Memory: 27520 KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 바구니 자리 수
            int M = Integer.parseInt(st.nextToken()); // 바구니 개수

            st = new StringTokenizer(br.readLine());
            
            // 대기 중인 바구니들의 수분량 큐
            Queue<Integer> waitWater = new LinkedList<>();
            // 대기 중인 바구니들의 번호 큐
            Queue<Integer> waitId = new LinkedList<>();

            for (int i = 1; i <= M; i++) {
                waitWater.offer(Integer.parseInt(st.nextToken()));
                waitId.offer(i);
            }

            // 현재 드럼 위에 있는 바구니들의 수분량 큐
            Queue<Integer> drumWater = new LinkedList<>();
            // 현재 드럼 위에 있는 바구니들의 번호 큐
            Queue<Integer> drumId = new LinkedList<>();

            // 처음에 드럼 자리(N개)만큼 채우기
            for (int i = 0; i < N; i++) {
                if (!waitWater.isEmpty()) {
                    drumWater.offer(waitWater.poll());
                    drumId.offer(waitId.poll());
                }
            }

            int lastBasketId = -1;

            // 드럼에 바구니가 없을 때까지 시뮬레이션
            while (!drumWater.isEmpty()) {
                int water = drumWater.poll();
                int id = drumId.poll();

                // 수분 감소 (C / 2, 소수점 버림)
                water /= 2;

                if (water == 0) {
                    lastBasketId = id; // 마지막으로 나간 바구니 번호 기억
                    
                    // 대기 중인 바구니가 있다면 빈자리에 즉시 투입
                    if (!waitWater.isEmpty()) {
                        drumWater.offer(waitWater.poll());
                        drumId.offer(waitId.poll());
                    }
                } else {
                    // 수분이 남았다면 회전시켜서 다시 뒤로 보냄
                    drumWater.offer(water);
                    drumId.offer(id);
                }
            }

            System.out.println("#" + test_case + " " + lastBasketId);
        }
    }
}