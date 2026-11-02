// SWEA #5607 · [Professional] 조합
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGKdbqczEDFAUo
// Language: JAVA
// Execution Time: 106 ms
// Memory: 42140 KB

import java.io.*;
import java.util.*;

public class Solution {
    // 문제에서 주어진 모듈러 값
    static final long MOD = 1234567891L;
    static final int MAX = 1000000;
    
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];

    // 거듭제곱을 구하는 함수 (분할 정복 이용, O(log exp))
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    // 팩토리얼과 역원 팩토리얼 미리 계산
    static void precompute() {
        fact[0] = 1;
        invFact[0] = 1;
        
        // 1부터 1,000,000까지 팩토리얼 미리 계산
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // 페르마의 소정리를 이용해 1,000,000!의 모듈러 역원 구하기
        invFact[MAX] = power(fact[MAX], MOD - 2);
        
        // 역방향으로 역원 팩토리얼 채우기
        for (int i = MAX - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    public static void main(String[] args) throws Exception {
        // 프로그램 시작 시 미리 계산 수행
        precompute();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // R이 0이거나 N과 같다면 조합 결과는 항상 1
            if (R == 0 || R == N) {
                sb.append("#").append(tc).append(" ").append(1).append("\n");
                continue;
            }

            // 조합 공식 적용: N! * (R!)^(-2) * ((N-R)!)^(-1) (모듈러 연산)
            long ans = fact[N];
            ans = (ans * invFact[R]) % MOD;
            ans = (ans * invFact[N - R]) % MOD;

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }
}