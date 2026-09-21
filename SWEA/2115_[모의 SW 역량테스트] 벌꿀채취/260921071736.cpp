// SWEA #2115 · [모의 SW 역량테스트] 벌꿀채취
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu
// Language: C++
// Execution Time: 7 ms
// Memory: 5988 KB

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, C;
int board[10][10];
int maxProfit[10][10];

// 부분집합(DFS)을 이용해 합이 C를 넘지 않는 최대 수익 계산
int dfsSubset(const vector<int>& honey, int idx, int currentSum, int currentProfit) {
    if (currentSum > C) {
        return 0;
    }
    if (idx == honey.size()) {
        return currentProfit;
    }

    // 1. 현재 벌통의 꿀을 채취하는 경우
    int include = dfsSubset(honey, idx + 1, currentSum + honey[idx], currentProfit + (honey[idx] * honey[idx]));
    
    // 2. 현재 벌통의 꿀을 채취하지 않는 경우
    int exclude = dfsSubset(honey, idx + 1, currentSum, currentProfit);

    return max(include, exclude);
}

// (r, c)에서 시작해서 길이 M 동안 얻을 수 있는 최대 수익을 구하는 함수
int getSegmentMaxProfit(int r, int c) {
    vector<int> honey(M);
    for (int i = 0; i < M; i++) {
        honey[i] = board[r][c + i];
    }
    return dfsSubset(honey, 0, 0, 0);
}

void solve(int test_case) {
    cin >> N >> M >> C;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
            maxProfit[i][j] = 0;
        }
    }

    // 1. 모든 가능한 길이 M 구간에 대해 최대 수익 미리 계산
    for (int i = 0; i < N; i++) {
        for (int j = 0; j <= N - M; j++) {
            maxProfit[i][j] = getSegmentMaxProfit(i, j);
        }
    }

    int ans = 0;

    // 2. 일꾼 1과 일꾼 2의 위치를 조합으로 선택 (겹치면 안 됨)
    for (int r1 = 0; r1 < N; r1++) {
        for (int c1 = 0; c1 <= N - M; c1++) {
            for (int r2 = r1; r2 < N; r2++) {
                // 같은 행이면 일꾼 1이 끝난 다음부터, 다른 행이면 0열부터 시작
                int startC = (r1 == r2) ? c1 + M : 0;
                
                for (int c2 = startC; c2 <= N - M; c2++) {
                    int total = maxProfit[r1][c1] + maxProfit[r2][c2];
                    ans = max(ans, total);
                }
            }
        }
    }

    cout << "#" << test_case << " " << ans << "\n";
}

int main(int argc, char** argv) {
    // 빠른 입출력을 위한 설정
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int test_case = 1; test_case <= T; ++test_case) {
        solve(test_case);
    }

    return 0;
}