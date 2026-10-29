// PROGRAMMERS #181934 · 조건 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/181934
// Language: cpp

#include <string>
#include <vector>

using namespace std;

int solution(string ineq, string eq, int n, int m) {
    int answer = 0;
    if (ineq == ">" & eq == "=")
        return n >= m;
    else if (ineq == "<" & eq=="=")
        return n<=m;
    else if (ineq == ">" & eq=="!")
        return n>m;
    else if (ineq == "<" & eq=="!")
        return n<m;
}