// PROGRAMMERS #12939 · 최댓값과 최솟값
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
// Language: C++
// Execution Time: 0.22 ms
// Memory: 4.8525 MB

#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> s1;
    stringstream ss(s);
    int number;
    while(ss >> number){
        s1.push_back(number);
        
    }
    
    sort(s1.begin(),s1.end());
    answer+=to_string(s1[0]);
    answer+=" ";
    answer+=to_string(s1[s1.size()-1]);
    
    return answer;
}