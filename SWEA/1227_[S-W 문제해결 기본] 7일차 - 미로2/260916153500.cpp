// SWEA #1227 · [S/W 문제해결 기본] 7일차 - 미로2
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
// Language: C++
// Execution Time: 9 ms
// Memory: 6044 KB

#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int board[100][100];
bool visited[100][100];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int bfs(int startX, int startY) {
    queue<pair<int, int>> q;
    q.push({startX, startY});
    visited[startX][startY] = true;

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

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
                    q.push({nx, ny});
                }
            }
        }
    }
    return 0; // 도달할 수 없는 경우
}

int main(int argc, char** argv) {
    // 빠른 입출력을 위한 설정
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // 미로2 문제는 테스트 케이스가 항상 10개 주어집니다.
    for (int test_case = 1; test_case <= 10; ++test_case) {
        int tc;
        cin >> tc; // 테스트 케이스 번호 읽기

        int startX = 0, startY = 0;

        // 배열 및 방문 기록 초기화
        memset(visited, 0, sizeof(visited));

        // 100 x 100 미로 입력 (공백 없이 붙어서 들어오므로 문자열/char로 처리)
        for (int i = 0; i < 100; i++) {
            string line;
            cin >> line;
            for (int j = 0; j < 100; j++) {
                board[i][j] = line[j] - '0'; // 문자를 숫자로 변환 ('2' -> 2)
                if (board[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // BFS 탐색 수행
        int result = bfs(startX, startY);

        // 출력 형식: #테스트케이스번호 결과
        cout << "#" << test_case << " " << result << "\n";
    }

    return 0;
}