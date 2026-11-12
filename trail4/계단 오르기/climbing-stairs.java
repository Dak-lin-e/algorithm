
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 1;

                
        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
                dp[i] += dp[i - 2];
            }

            if (i >= 3) {
                dp[i] += dp[i - 3];
            }

            dp[i] %= 10007;
        }

        System.out.println(dp[n]);
    }
}
