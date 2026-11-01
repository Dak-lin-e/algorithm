
import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, k, m;
    static int[][] grid;
    static int answer = 0;

    static ArrayList<Node> stones = new ArrayList<>();
    static ArrayList<Node> starts = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // BFS: 모든 시작점에서 도달 가능한 칸 계산
    static int bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<Node> queue = new ArrayDeque<>();

        int cnt = 0;

        // 여러 시작점을 하나의 큐에 추가
        for (Node start : starts) {
            if (!visited[start.x][start.y]) {
                visited[start.x][start.y] = true;
                queue.offer(start);
                cnt++;
            }
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx < 0 || nx >= n ||
                    ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] || grid[nx][ny] == 1) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny));
                cnt++;
            }
        }

        return cnt;
    }

    // 조합: 제거할 돌 m개 선택
    static void jaegui(int cnt, int idx) {

        // 돌 m개를 제거한 경우
        if (cnt == m) {
            answer = Math.max(answer, bfs());
            return;
        }

        for (int i = idx; i < stones.size(); i++) {
            Node stone = stones.get(i);

            // 1. 돌 제거
            grid[stone.x][stone.y] = 0;

            // 2. 다음 돌 선택
            jaegui(cnt + 1, i + 1);

            // 3. 백트래킹: 돌 복구
            grid[stone.x][stone.y] = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];

        // 격자 입력 및 돌 위치 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    stones.add(new Node(i, j));
                }
            }
        }

        // 시작점 입력 (1-based → 0-based)
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            starts.add(new Node(r, c));
        }

        jaegui(0, 0);

        System.out.println(answer);
        sc.close();
    }
}
