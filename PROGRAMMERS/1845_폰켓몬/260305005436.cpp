// PROGRAMMERS #1845 · 폰켓몬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// Language: cpp

#include <vector>
#include <unordered_set>
#include <algorithm> // min 함수 사용을 위해

using namespace std;

int solution(vector<int> nums) {
    // 1. unordered_set에 배열을 통째로 넣어서 중복을 싹 제거함
    unordered_set<int> unique_nums(nums.begin(), nums.end());
    
    // 2. 내가 최대로 고를 수 있는 폰켓몬 수 (N / 2)
    int max_choose = nums.size() / 2;
    
    // 3. 중복 제거된 폰켓몬의 종류 수
    int unique_count = unique_nums.size();
    
    // 4. 둘 중 더 작은 값을 리턴
    return min(max_choose, unique_count);
}