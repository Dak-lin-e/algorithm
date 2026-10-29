// PROGRAMMERS #60062 · 외벽 점검
// https://school.programmers.co.kr/learn/courses/30/lessons/60062
// Language: java

import java.util.*;

class Solution {

    static int answer;
    static int n;
    static int[] weak;
    static int[] dist;

    static boolean[] visited;
    static int[] friends;

    public int solution(int n, int[] weak, int[] dist) {

        this.n = n;
        this.weak = weak;
        this.dist = dist;

        answer = dist.length + 1;

        // 원형을 직선으로 만들기 위해 weak를 2배로 확장
        int weakLength = weak.length;

        int[] extended = new int[weakLength * 2];

        for (int i = 0; i < weakLength; i++) {
            extended[i] = weak[i];
            extended[i + weakLength] = weak[i] + n;
        }

        // 친구 투입 순서의 모든 경우를 확인
        visited = new boolean[dist.length];
        friends = new int[dist.length];

        dfs(0, extended);

        if (answer == dist.length + 1) {
            return -1;
        }

        return answer;
    }

    // 친구 순열 생성
    static void dfs(int depth, int[] extended) {

        // 친구 순서를 하나 완성
        if (depth == dist.length) {

            // 모든 시작점을 확인
            for (int start = 0; start < weak.length; start++) {

                check(start, extended);
            }

            return;
        }

        for (int i = 0; i < dist.length; i++) {

            if (!visited[i]) {

                visited[i] = true;
                friends[depth] = dist[i];

                dfs(depth + 1, extended);

                visited[i] = false;
            }
        }
    }

    // 특정 시작점에서 친구들을 투입
    static void check(int start, int[] extended) {

        int friendIndex = 0;

        // 첫 번째 취약점부터 시작
        int current = start;

        while (current < start + weak.length) {

            // 모든 친구를 사용했으면 실패
            if (friendIndex >= friends.length) {
                return;
            }

            // 현재 친구가 담당할 수 있는 마지막 위치
            int end = extended[current] + friends[friendIndex];

            friendIndex++;

            // 현재 친구가 담당할 수 있는 취약점들을 모두 통과
            current++;

            while (current < start + weak.length
                    && extended[current] <= end) {

                current++;
            }
        }

        // 모든 취약점을 점검했다면 친구 수 갱신
        answer = Math.min(answer, friendIndex);
    }
}