// SWEA #26933 · 삼색 칩 대회
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpElaHaHHBIQj
// Language: JAVA
// Execution Time: 93 ms
// Memory: 26240 KB

import java.util.*;
import java.io.*;

class Solution {
    static int[] chips;

    // a번 참가자와 b번 참가자가 붙었을 때 승자의 번호를 반환하는 함수
    static int fight(int a, int b) {
        int chipA = chips[a];
        int chipB = chips[b];

        // 1: 빨강, 2: 파랑, 3: 초록
        // 같은 칩을 골랐다면 번호가 더 작은 사람이 승리
        if (chipA == chipB) {
            return (a < b) ? a : b;
        }

        // 빨강(1)은 초록(3)을 이김
        if (chipA == 1 && chipB == 3) return a;
        if (chipA == 3 && chipB == 1) return b;

        // 파랑(2)은 빨강(1)을 이김
        if (chipA == 2 && chipB == 1) return a;
        if (chipA == 1 && chipB == 2) return b;

        // 초록(3)은 파랑(2)을 이김
        if (chipA == 3 && chipB == 2) return a;
        if (chipA == 2 && chipB == 3) return b;

        return a;
    }

    // left부터 right까지의 구간에서 승자를 가려내는 분할정복 함수
    static int solve(int left, int right) {
        // 1. 구간에 사람이 1명만 남았다면 그 사람이 대표
        if (left == right) {
            return left;
        }

        // 2. 반으로 쪼개기
        int mid = (left + right) / 2;
        int winner1 = solve(left, mid);      // 왼쪽 묶음의 대표
        int winner2 = solve(mid + 1, right); // 오른쪽 묶음의 대표

        // 3. 두 대표끼리 승부 겨루기
        return fight(winner1, winner2);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());

            // 1번부터 N번까지 칩 정보를 담기 위해 크기를 N + 1로 설정
            chips = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                chips[i] = Integer.parseInt(st.nextToken());
            }

            // 1번부터 N번까지 전체 구간에서 최종 우승자 찾기
            int champion = solve(1, N);

            System.out.println("#" + test_case + " " + champion);
        }
    }
}