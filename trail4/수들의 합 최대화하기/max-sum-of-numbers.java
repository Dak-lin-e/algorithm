import java.util.*;

public class Main {

    static int[][] grid;
    static boolean[] visited;
    static int n;
    static int answer = Integer.MIN_VALUE;

    static void dfs(int row, int sum) {

        // 모든 행을 선택한 경우
        if(row == n) {
            answer = Math.max(answer, sum);
            return;
        }

        // 현재 행에서 선택할 열 탐색
        for(int col = 0; col < n; col++) {

            if(!visited[col]) {

                visited[col] = true;

                dfs(row + 1, sum + grid[row][col]);

                visited[col] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}