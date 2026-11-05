
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 첫 번째 원소로 초기화
        dp[0] = nums[0];

        int ans = dp[0];

        for (int i = 1; i < n; i++) {
            // 이전 연속합을 이어갈지, 새로 시작할지 선택
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

            // 전체 최댓값 갱신
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
        sc.close();
    }
}
