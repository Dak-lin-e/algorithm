import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // 각 위치별 경로의 정수들 중 최솟값의 최댓값을 기록.
        int dp[][] = new int[n][n];
        dp[0][0]=matrix[0][0];

            for (int j = 1; j < n; j++) {
                dp[0][j]= Math.min(dp[0][j-1],matrix[0][j]);
                dp[j][0]=Math.min(dp[j-1][0],matrix[j][0]);
            }
        
        

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =Math.max( Math.min(dp[i-1][j],matrix[i][j]), Math.min(dp[i][j-1],matrix[i][j]) );
            }
        }
        System.out.println(dp[n-1][n-1]);

        



    }
}