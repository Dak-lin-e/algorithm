// PROGRAMMERS #181941 · 문자 리스트를 문자열로 변환하기
// https://school.programmers.co.kr/learn/courses/30/lessons/181941
// Language: c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


char* solution(const char* arr[], size_t arr_len) {
    
    size_t total_length = arr_len;
    
    char* answer = (char*)malloc(total_length + 1);
    
    if (answer == NULL) {
        return NULL; 
    }
    
    for (size_t i = 0; i < arr_len; i++) {
        answer[i] = arr[i][0];
    }

    answer[total_length] = '\0';

    return answer;
}