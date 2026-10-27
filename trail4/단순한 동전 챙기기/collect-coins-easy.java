
import java.util.*;
import java.io.*;

class Node {
    int num;
    int x;
    int y;

    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static ArrayList<Node> coins = new ArrayList<>();
    static ArrayList<Node> selected = new ArrayList<>();

    static Node start, end;
    static int answer = Integer.MAX_VALUE;

    // 두 좌표 사이의 최단 거리
    static int distance(Node a, Node b) {
        return Math.abs(a.x - b.x)
             + Math.abs(a.y - b.y);
    }

    // 선택한 동전 3개의 총 이동 거리 계산
    static void calculate() {
        int sum = 0;

        sum += distance(start, selected.get(0));
        sum += distance(selected.get(0), selected.get(1));
        sum += distance(selected.get(1), selected.get(2));
        sum += distance(selected.get(2), end);

        answer = Math.min(answer, sum);
    }

    // 동전 3개를 선택하는 조합 DFS
    static void jaegui(int cnt, int idx) {

        // 동전 3개 선택 완료
        if (cnt == 3) {
            calculate();
            return;
        }

        for (int i = idx; i < coins.size(); i++) {

            // 동전 선택
            selected.add(coins.get(i));

            // 다음 동전 선택
            jaegui(cnt + 1, i + 1);

            // 백트래킹
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);

                if (ch == 'S') {
                    start = new Node(0, i, j);
                }
                else if (ch == 'E') {
                    end = new Node(0, i, j);
                }
                else if (ch >= '1' && ch <= '9') {
                    coins.add(new Node(ch - '0', i, j));
                }
            }
        }

        // 동전이 3개 미만이면 불가능
        if (coins.size() < 3) {
            System.out.println(-1);
            return;
        }

        // 동전 번호 오름차순 정렬
        coins.sort((a, b) ->
            Integer.compare(a.num, b.num)
        );

        jaegui(0, 0);

        System.out.println(answer);
        sc.close();
    }
}
