// PROGRAMMERS #181933 · flag에 따라 다른 값 반환하기
// https://school.programmers.co.kr/learn/courses/30/lessons/181933
// Language: c

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b, bool flag) {
    if (flag == true)
        return a+b;
    else 
        return a-b;
}