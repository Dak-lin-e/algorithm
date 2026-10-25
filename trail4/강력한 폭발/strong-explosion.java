
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int[][] grid;
    static int[][] count;
    static int total = 0;
    static int max = 0;

    static Deque<Node> answer = new ArrayDeque<>();

    // 0~3: 2번 폭탄 (십자)
    // 4~7: 3번 폭탄 (대각선)
    // 8~11: 1번 폭탄 (세로)
    static int[] dx = {
        1, -1, 0, 0,
        1, 1, -1, -1,
        1, 2, -1, -2
    };

    static int[] dy = {
        0, 0, 1, -1,
        1, -1, -1, 1,
        0, 0, 0, 0
    };

    static void printanswer() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] > 0) {
                    sum++;
                }
            }
        }

        max = Math.max(max, sum);
    }

    static void jaegui(int current) {

        // 모든 폭탄의 종류를 선택한 경우
        if (current == total) {
            printanswer();
            return;
        }

        Node n1 = answer.pollFirst();

        // 폭탄 종류 3가지
        for (int i = 0; i < 3; i++) {

            // 1. 폭탄 중심 방문
            count[n1.x][n1.y]++;

            // 2. 폭탄 공격 범위 적용
            for (int j = 4 * i; j < 4 * (i + 1); j++) {
                int nx = n1.x + dx[j];
                int ny = n1.y + dy[j];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n) {

                    count[nx][ny]++;
                }
            }

            // 3. 다음 폭탄 선택
            jaegui(current + 1);

            // 4. 백트래킹: 공격 범위 복구
            for (int j = 4 * i; j < 4 * (i + 1); j++) {
                int nx = n1.x + dx[j];
                int ny = n1.y + dy[j];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n) {

                    count[nx][ny]--;
                }
            }

            // 5. 폭탄 중심 복구
            count[n1.x][n1.y]--;
        }

        // 다음 재귀 탐색을 위해 원래 위치에 복구
        answer.addFirst(n1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        count = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 폭탄이 설치된 위치 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    answer.addLast(new Node(i, j));
                }
            }
        }

        jaegui(0);

        System.out.println(max);
        sc.close();
    }
}
