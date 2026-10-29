// PROGRAMMERS #340205 · [PCCE 기출문제] 3번 / 수 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/340205
// Language: cpp

#include <iostream>

using namespace std;

int main(void) {
    int number;
    cin >> number;
    
    int answer = 0;
    
    for(int i=0; i<number; i++){
        answer += number % 100;
        number /= 100;
    }
    cout << answer << endl;
    return 0;
}