// SWEA #3289 · 서로소 집합
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr
// Language: C++
// Execution Time: 250 ms
// Memory: 10048 KB

#include<iostream>
#include<vector>
#include<string>

using namespace std;

// [핵심 1] 내가 속한 집합의 '대표 조장'을 찾는 함수
int findParent(vector<int>& parent, int x) {
    if (parent[x] == x) return x;
    // 경로 압축: 조장을 찾으러 올라간 김에 부모를 최종 조장으로 바로 바꿈 (속도 극대화)
    return parent[x] = findParent(parent, parent[x]); 
}

// [핵심 2] 두 집합을 하나로 합치는 함수
void unionParent(vector<int>& parent, int a, int b) {
    a = findParent(parent, a);
    b = findParent(parent, b);
    if (a != b) {
        parent[b] = a; // b의 조장을 a의 조장 밑으로 편입시킴
    }
}

int main(int argc, char** argv)
{
    // Fast I/O: 백준/SWEA에서 입출력 속도로 인한 시간초과를 방지
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for(int test_case = 1; test_case <= T; ++test_case)
    {
        int n, m;
        cin >> n >> m;
        
        // 기존의 무거운 2차원 벡터 대신, 부모 노드 번호만 담을 1차원 벡터 선언
        vector<int> parent(n + 1);
        for(int i = 0; i <= n; i++) {
            parent[i] = i; // 초기에는 모두 자기가 자기 팀의 조장
        }

        string answer = "";
        
        for(int i = 0; i < m; i++){
            int op, a, b;
            cin >> op >> a >> b;
            
            if(op == 0){
                // 0번 연산: 무거운 벡터 insert 대신 숫자 하나만 툭 바꿔서 합치기
                unionParent(parent, a, b);
            }
            else {
                // 1번 연산: 두 원소의 최종 조장이 같은지 1차원 배열로 비교
                if(findParent(parent, a) == findParent(parent, b)){
                    answer += "1";
                }
                else{
                    answer += "0";
                }
            }     
        }
        cout << "#" << test_case << " " << answer << "\n";
    }
    return 0;
}
