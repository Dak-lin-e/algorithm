// SWEA #6808 · 규영이와 인영이의 카드게임
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// Language: JAVA
// Execution Time: 3774 ms
// Memory: 27904 KB

import java.util.*;
import java.io.*;

class Solution {
    static int[] gyoung;
    static int[] iyoung;
    static int winCount, loseCount;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gyoung = new int[9];
            boolean[] cardCheck = new boolean[19]; // 1 ~ 18 카드 사용 여부 체크

            for (int i = 0; i < 9; i++) {
                gyoung[i] = Integer.parseInt(st.nextToken());
                cardCheck[gyoung[i]] = true; // 규영이가 가진 카드 체크
            }

            // 규영이가 가지고 있지 않은 남은 카드를 인영이에게 부여
            iyoung = new int[9];
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!cardCheck[i]) {
                    iyoung[idx++] = i;
                }
            }

            winCount = 0;
            loseCount = 0;

            // 인영이 카드의 순열을 구하기 위한 배열
            boolean[] permVisited = new boolean[9];
            int[] currentIyoung = new int[9];

            // 순열 탐색 시작 (9! 경우의 수)
            permute(0, permVisited, currentIyoung);

            System.out.println("#" + test_case + " " + winCount + " " + loseCount);
        }
    }

    // 인영이 카드의 순열을 만드는 DFS 함수
    static void permute(int depth, boolean[] permVisited, int[] currentIyoung) {
        if (depth == 9) {
            calculateGame(currentIyoung);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!permVisited[i]) {
                permVisited[i] = true;
                currentIyoung[depth] = iyoung[i];
                permute(depth + 1, permVisited, currentIyoung);
                permVisited[i] = false;
            }
        }
    }

    // 완성된 한 가지 경우의 수에 대해 게임 점수 계산
    static void calculateGame(int[] currentIyoung) {
        int gScore = 0;
        int iScore = 0;

        for (int i = 0; i < 9; i++) {
            if (gyoung[i] > currentIyoung[i]) {
                gScore += gyoung[i] + currentIyoung[i];
            } else if (gyoung[i] < currentIyoung[i]) {
                iScore += gyoung[i] + currentIyoung[i];
            }
        }

        if (gScore > iScore) {
            winCount++;
        } else if (gScore < iScore) {
            loseCount++;
        }
        // 무승부인 경우는 문제에서 세지 않으므로 조건에서 제외
    }
}