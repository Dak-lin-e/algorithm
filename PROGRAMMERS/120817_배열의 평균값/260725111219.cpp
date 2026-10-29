// PROGRAMMERS #120817 · 배열의 평균값
// https://school.programmers.co.kr/learn/courses/30/lessons/120817
// Language: cpp

#include <string>
#include <vector>

using namespace std;

double solution(vector<int> numbers) {
    double answer = 0;
    for(int a : numbers){
        answer += (double)a;
        
    }
    return (answer/numbers.size());
}