// SWEA #26924 · 트레일 달리기 급수대
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wowZKHX3HBIQj
// Language: JAVA
// Execution Time: 78 ms
// Memory: 25600 KB

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()); // 한 번에 이동 가능한 최대 칸 수
            int N = Integer.parseInt(st.nextToken()); // 종점(결승선) 위치
            int M = Integer.parseInt(st.nextToken()); // 급수대 개수

            // 전체 코스 배열 (급수대가 있으면 true)
            boolean[] station = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int pos = Integer.parseInt(st.nextToken());
                station[pos] = true;
            }

            int current = 0; // 현재 위치
            int ans = 0;     // 급수 횟수

            while (true) {
                // 1. 현재 위치에서 K를 더한 값이 종점 이상이면 탐색 종료
                if (current + K >= N) {
                    break;
                }

                // 2. 현재 위치에서 갈 수 있는 가장 먼 곳(current + K)부터 거꾸로 탐색
                boolean found = false;
                for (int step = K; step >= 1; step--) {
                    int next = current + step;
                    
                    // 그 위치에 급수대가 있다면 거기로 이동!
                    if (station[next]) {
                        current = next;
                        ans++;
                        found = true;
                        break; // 가장 먼 곳을 찾았으므로 탈출
                    }
                }

                // 3. 만약 K칸 이내에 갈 수 있는 급수대가 아예 없다면 도달 불가 (0 출력)
                if (!found) {
                    ans = 0;
                    break;
                }
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }
}