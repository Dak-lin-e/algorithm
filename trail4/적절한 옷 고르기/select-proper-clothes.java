
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] s = new int[n];
        int[] e = new int[n];
        int[] v = new int[n];

        for(int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // dp[옷 번호][날짜]
        int[][] dp = new int[n][m + 1];

        // 도달할 수 없는 상태는 -1
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 1일 차 초기화
        for(int i = 0; i < n; i++) {

            if(s[i] <= 1 && 1 <= e[i]) {
                dp[i][1] = 0;
            }
        }

        // 2일 차부터 M일 차까지
        for(int day = 2; day <= m; day++) {

            for(int i = 0; i < n; i++) {

                // 오늘 i번 옷을 입을 수 있는지 확인
                if(day < s[i] || day > e[i]) {
                    continue;
                }

                // 전날 입었던 옷 탐색
                for(int j = 0; j < n; j++) {

                    // 전날 j번 옷을 입을 수 있었는지 확인
                    if(dp[j][day - 1] == -1) {
                        continue;
                    }

                    int diff = Math.abs(v[i] - v[j]);

                    dp[i][day] = Math.max(
                        dp[i][day],
                        dp[j][day - 1] + diff
                    );
                }
            }
        }

        // 마지막 날의 최댓값
        int answer = 0;

        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][m]);
        }

        System.out.println(answer);
    }
}
