// PROGRAMMERS #12941 · 최솟값 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12941
// Language: C++

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    sort(A.begin(),A.end());
    sort(B.begin(),B.end());
    
    for(int i=0; i<A.size(); i++){
        answer += A[i]*B[A.size()-i-1];
        
    }
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

    return answer;
}