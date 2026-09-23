// PROGRAMMERS #340212 · [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
// https://school.programmers.co.kr/learn/courses/30/lessons/340212
// Language: C++
// Execution Time: 70.63 ms
// Memory: 11.080476 MB

#include <bits/stdc++.h>

using namespace std;

// level로 제한 시간(limit) 내에 해결 가능한지 확인하는 함수
static bool check(const vector<int>& diffs, const vector<int>& times, long long limit, int level){
    long long hangtime = 0;
    
    for(int i = 0; i < diffs.size(); i++){
        if(diffs[i] <= level){
            hangtime += times[i];           
        }
        else{
            long long prev_time = (i > 0) ? times[i-1] : 0;
            hangtime += (long long)(diffs[i] - level) * (times[i] + prev_time) + times[i];          
        }
        
        // 탐색 도중 이미 제한 시간을 초과하면 더 볼 필요 없이 false
        if(hangtime > limit) return false;
    }
    return true;
}

int solution(vector<int> diffs, vector<int> times, long long limit) {
    int answer = 1;
    int start = 1;
    // 최댓값은 diffs 중 가장 큰 값
    int end = *max_element(diffs.begin(), diffs.end()); 
    
    // 이분 탐색(Binary Search) 진행
    while(start <= end) {
        int mid = start + (end - start) / 2;
        
        if(check(diffs, times, limit, mid)) {
            answer = mid; // 해결 가능하므로 정답 후보로 저장
            end = mid - 1; // 더 작은 level 레벨이 있는지 찾기 위해 왼쪽 탐색
        }
        else {
            start = mid + 1; // 해결 불가능하므로 더 높은 레벨 찾기 위해 오른쪽 탐색
        }
    }
    
    return answer;
}
