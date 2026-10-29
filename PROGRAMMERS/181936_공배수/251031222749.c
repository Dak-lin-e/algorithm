// PROGRAMMERS #181936 · 공배수
// https://school.programmers.co.kr/learn/courses/30/lessons/181936
// Language: c

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int number, int n, int m) {
    if (number % n ==0 && number % m==0)
        return 1;
    else
        return 0;
}