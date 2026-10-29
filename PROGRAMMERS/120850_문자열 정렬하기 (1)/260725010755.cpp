// PROGRAMMERS #120850 · 문자열 정렬하기 (1)
// https://school.programmers.co.kr/learn/courses/30/lessons/120850
// Language: cpp

#include <string>
#include <vector>
#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer;
    // 1. 문자열을 순회하며 숫자('0' ~ '9')인 것만 골라내기
    for (char c : my_string) {
        if (isdigit(c)) {
            // 문자를 숫자로 변환하여 리스트에 추가 (예: '3' -> 3)
            answer.push_back(c - '0');
        }
    }
    
    // 2. 오름차순 정렬
    sort(answer.begin(), answer.end());
    return answer;
}