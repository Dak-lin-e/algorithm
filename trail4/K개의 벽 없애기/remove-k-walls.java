import java.util.*;
import java.io.*;

class Node {
    int x, y, dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {

    static int n, k;
    static int[][] grid;

    static int r1, r2, c1, c2;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static ArrayList<Node> rocks = new ArrayList<>();
    static ArrayList<Node> destroyrocks = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    // BFS
    static int bfs() {

        Deque<Node> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[n][n];

        queue.add(new Node(r1 - 1, c1 - 1, 0));
        visited[r1 - 1][c1 - 1] = true;

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            // 기존 최솟값보다 짧은 경로가 불가능하면 종료
            if (cur.dist >= answer) {
                break;
            }

            // 목적지 도착
            if (cur.x == r2 - 1 && cur.y == c2 - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (grid[nx][ny] == 1) {
                    continue;
                }

                visited[nx][ny] = true;

                queue.add(new Node(nx, ny, cur.dist + 1));
            }
        }

        return -1;
    }

    // 선택한 돌 부수기
    static void destroyRocks() {

        for (Node rock : destroyrocks) {
            grid[rock.x][rock.y] = 0;
        }

        int result = bfs();

        if (result != -1) {
            answer = Math.min(answer, result);
        }

        // 원상 복구
        for (Node rock : destroyrocks) {
            grid[rock.x][rock.y] = 1;
        }
    }

    // 조합 생성
    static void dfs(int current) {

        // 이미 최솟값 0을 찾았다면 종료
        if (answer == 0) {
            return;
        }

        // K개의 돌 선택 완료
        if (destroyrocks.size() == k) {
            destroyRocks();
            return;
        }

        // 남은 선택 개수를 고려한 탐색
        for (int i = current;
             i <= rocks.size() - (k - destroyrocks.size());
             i++) {

            destroyrocks.add(rocks.get(i));

            // 반드시 i+1부터 탐색
            dfs(i + 1);

            destroyrocks.remove(destroyrocks.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    rocks.add(new Node(i, j, 0));
                }
            }
        }

        r1 = sc.nextInt();
        c1 = sc.nextInt();

        r2 = sc.nextInt();
        c2 = sc.nextInt();

        dfs(0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}