// SWEA #26937 · 창고 운반차의 최단 운행
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpF0KHbHHBIQj
// Language: C++
// Execution Time: 18 ms
// Memory: 6020 KB

#include <vector>
#include <string>
#include <iostream>
#include <queue>

using namespace std;

class point {
public:
    int x;
    int y;
    int dist;
    point(int x, int y, int dist) {
        this->x = x;
        this->y = y;
        this->dist = dist;
    }
};

int main(int argc, char** argv) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    
    for(int test_case = 1; test_case <= T; ++test_case) {
        int N;
        cin >> N;
        cin.ignore(); // 버퍼 비우기
        
        vector<vector<int>> board;
        for(int i = 0; i < N; i++) {
            string s;
            getline(cin, s);
            vector<int> temp;
            for(char c : s) {
                if(c >= '0' && c <= '9') {
                    temp.push_back(c - '0');
                }
            }
            board.push_back(temp);
        }
        
        vector<vector<bool>> check(N, vector<bool>(N, false));
        queue<point> q;
        
        int startx = -1, starty = -1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 2) {
                    startx = i;
                    starty = j;
                    check[i][j] = true;
                }
            }
        }
        
        q.push(point(startx, starty, 0));
        
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int answer = 0;
        bool found = false;
        
        while(!q.empty() && !found) {
            point p = q.front();
            q.pop();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                // 1. [중요] 범위를 먼저 체크해야 합니다!
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    // 2. 목적지(3)에 도착한 경우
                    if(board[nx][ny] == 3) {
                        answer = p.dist; // 거쳐 간 칸의 개수
                        found = true;
                        break;
                    }
                    
                    // 3. 빈 칸(0)이고 아직 방문하지 않은 경우
                    if(board[nx][ny] == 0 && !check[nx][ny]) {
                        check[nx][ny] = true;
                        q.push(point(nx, ny, p.dist + 1));
                    }
                }
            }
        }
        
        // [중요] 줄바꿈(\n) 포함해서 출력
        cout << "#" << test_case << " " << answer << "\n";
    }
    
    return 0;
}