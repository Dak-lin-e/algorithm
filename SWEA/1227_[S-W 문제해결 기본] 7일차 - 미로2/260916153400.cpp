// SWEA #1227 · [S/W 문제해결 기본] 7일차 - 미로2
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
// Language: C++
// Execution Time: 10 ms
// Memory: 6044 KB

#include <iostream>
#include <vector>
#include <stack>
#include <string>
#include <cstring>

using namespace std;

int board[100][100];
bool visited[100][100];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

// 스택을 이용한 비재귀(반복문) DFS 함수
int dfs(int startX, int startY) {
    stack<pair<int, int>> s;
    s.push({startX, startY});
    visited[startX][startY] = true;

    while (!s.empty()) {
        int x = s.top().first;
        int y = s.top().second;
        s.pop();

        // 도착점(3)에 도달한 경우
        if (board[x][y] == 3) {
            return 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                // 벽(1)이 아니고 아직 방문하지 않은 길이라면
                if (board[nx][ny] != 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    s.push({nx, ny});
                }
            }
        }
    }
    
    return 0; // 도달할 수 없는 경우
}

int main(int argc, char** argv) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int test_case = 1; test_case <= 10; ++test_case) {
        int tc;
        cin >> tc;

        int startX = 0, startY = 0;
        memset(visited, 0, sizeof(visited));

        for (int i = 0; i < 100; i++) {
            string line;
            cin >> line;
            for (int j = 0; j < 100; j++) {
                board[i][j] = line[j] - '0';
                if (board[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = dfs(startX, startY);

        cout << "#" << test_case << " " << result << "\n";
    }

    return 0;
}