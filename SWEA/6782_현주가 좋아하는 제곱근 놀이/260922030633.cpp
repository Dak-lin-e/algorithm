// SWEA #6782 · 현주가 좋아하는 제곱근 놀이
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgqsAlKr9sDFAW0
// Language: C++
// Execution Time: 9 ms
// Memory: 5988 KB

#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char** argv) {
    // 백준/SWEA 등에서 입출력 속도를 극대화하는 설정
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case) {
        long long n;
        cin >> n;
        
        long long cnt = 0; // 더하고 나누는 총 연산 횟수
        
        while (n > 2) {
            long long root_N = round(sqrt(n));
            
            // 1. 현재 n이 완전제곱수인 경우
            if (root_N * root_N == n) {
                n = root_N; // 제곱근으로 축소
                cnt += 1;
            } 
            // 2. 완전제곱수가 아닌 경우 -> 다음 제곱수까지 한 번에 점프!
            else {
                // n보다 큰 다음 정수 제곱근을 구함
                // sqrt(n)을 내림(floor)한 값에 + 1을 하면 다음 제곱근이 됨
                long long next_root = (long long)sqrt(n) + 1;
                long long next_square = next_root * next_root;
                
                // 다음 제곱수가 되기 위해 더해야 하는 횟수 계산
                long long diff = next_square - n;
                
                cnt += diff;      // 1을 diff번 더한 만큼 카운트 증가
                n = next_root;    // n을 next_square로 만들고 바로 제곱근을 취한 상태(next_root)로 점프
                cnt += 1;         // 제곱근을 취하는 연산 1회 추가
            }
        }
        
        // n이 2가 되었을 때의 최종 결과 출력
        cout << "#" << test_case << " " << cnt << "\n";
    }
    return 0;
}
