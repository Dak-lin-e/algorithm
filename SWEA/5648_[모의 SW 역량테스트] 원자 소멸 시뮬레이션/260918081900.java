// SWEA #5648 · [모의 SW 역량테스트] 원자 소멸 시뮬레이션
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
// Language: JAVA
// Execution Time: 2861 ms
// Memory: 139444 KB

import java.util.*;
import java.io.*;

class Atom {
    int x, y, d, e;
    boolean isAlive;

    public Atom(int x, int y, int d, int e) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.e = e;
        this.isAlive = true;
    }
}

class Solution {
    // 상(0), 하(1), 좌(2), 우(3)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            List<Atom> atoms = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2; // 0.5초 단위 충돌 처리를 위해 2배
                int y = Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                atoms.add(new Atom(x, y, d, e));
            }

            long totalEnergy = 0;
            Map<Integer, List<Atom>> map = new HashMap<>();

            // 최대 4000초 동안 시뮬레이션
            for (int time = 0; time <= 4000; time++) {
                map.clear(); // 매번 새로 할당하지 않고 기존 맵 비우기 (GC 부하 방지)
                int aliveCount = 0;

                // 1. 살아있는 모든 원자 한 칸씩 이동
                for (int i = 0; i < atoms.size(); i++) {
                    Atom atom = atoms.get(i);
                    if (!atom.isAlive) continue;

                    atom.x += dx[atom.d];
                    atom.y += dy[atom.d];

                    // 격자 범위를 완전히 벗어난 경우
                    if (atom.x < -4000 || atom.x > 4000 || atom.y < -4000 || atom.y > 4000) {
                        atom.isAlive = false;
                        continue;
                    }

                    aliveCount++;

                    // 문자열 대신 정수형 키 사용 (좌표값에 오프셋 4000을 더해 유일한 정수 키 생성)
                    int key = (atom.x + 4000) * 10000 + (atom.y + 4000);
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(atom);
                }

                // 살아있는 원자가 없으면 조기 종료
                if (aliveCount == 0) break;

                // 2. 같은 좌표에 2개 이상 모인 경우 충돌 처리
                for (List<Atom> list : map.values()) {
                    if (list.size() > 1) {
                        for (int i = 0; i < list.size(); i++) {
                            Atom atom = list.get(i);
                            totalEnergy += atom.e;
                            atom.isAlive = false; // 소멸
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + totalEnergy);
        }
    }
}