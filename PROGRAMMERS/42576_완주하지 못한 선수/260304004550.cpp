// PROGRAMMERS #42576 · 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// Language: cpp

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> participant1;
    for (int i = 0; i < participant.size(); i++) {
        participant1[participant[i]]++;
    }
    
    for (int i = 0; i < completion.size(); i++) {
        participant1[completion[i]]--;
    }
    
    for (auto pair : participant1) {
        if (pair.second > 0) {
            return pair.first;
        }
    }
    
    return "";
}