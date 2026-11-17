
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];

        // 도달하지 않은 상태는 -1로 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 도달할 수 없는 상태는 건너뛰기
                if (dp[i][j] == -1) {
                    continue;
                }

                // 1. 남우의 카드가 더 작은 경우
                if (a[i] > b[j]) {
                    dp[i][j + 1] = Math.max(
                        dp[i][j + 1],
                        dp[i][j] + b[j]
                    );
                }

                // 2. 상대방의 카드가 더 작은 경우
                else if (a[i] < b[j]) {
                    dp[i + 1][j] = Math.max(
                        dp[i + 1][j],
                        dp[i][j]
                    );
                }

                // 3. 두 카드 모두 버리는 경우
                dp[i + 1][j + 1] = Math.max(
                    dp[i + 1][j + 1],
                    dp[i][j]
                );
            }
        }

        // 한쪽의 카드가 모두 소진되면 게임 종료
        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, dp[n][i]);
            answer = Math.max(answer, dp[i][n]);
        }

        System.out.println(answer);
    }
}
