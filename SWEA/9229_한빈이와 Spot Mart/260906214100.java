// SWEA #9229 · 한빈이와 Spot Mart
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
// Language: JAVA
// Execution Time: 120 ms
// Memory: 31352 KB

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] snacks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            // 1. 오름차순 정렬
            Arrays.sort(snacks);

            int maxWeight = -1;
            int left = 0;
            int right = N - 1;

            // 2. 투 포인터 탐색
            while (left < right) {
                int sum = snacks[left] + snacks[right];

                if (sum <= M) {
                    // M을 넘지 않는다면 최댓값 갱신 후, 더 큰 합을 만들기 위해 왼쪽 포인터를 오른쪽으로 이동
                    maxWeight = Math.max(maxWeight, sum);
                    left++;
                } else {
                    // M을 초과한다면 합을 줄이기 위해 오른쪽 포인터를 왼쪽으로 이동
                    right--;
                }
            }

            System.out.println("#" + test_case + " " + maxWeight);
        }
    }
}