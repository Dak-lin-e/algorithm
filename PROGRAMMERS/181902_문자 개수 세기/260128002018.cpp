// PROGRAMMERS #181902 · 문자 개수 세기
// https://school.programmers.co.kr/learn/courses/30/lessons/181902
// Language: cpp

#include <string>
#include <vector>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer(52,0);
    
    for(auto &e : my_string){
        if (e >='A' && e<='Z')
            answer[e - 'A']++;
        else 
            answer[e-'a'+26]++;
        
    }
    return answer;
}