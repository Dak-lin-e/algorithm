// PROGRAMMERS #181941 · 문자 리스트를 문자열로 변환하기
// https://school.programmers.co.kr/learn/courses/30/lessons/181941
// Language: c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// arr_len: 배열 arr의 길이
// arr의 원소는 길이가 1인 문자열 ("a", "b" 등)입니다.
char* solution(const char* arr[], size_t arr_len) {
    
    // 1. 최종 문자열의 총 길이는 배열의 길이와 같습니다. (각 원소가 길이 1이기 때문)
    size_t total_length = arr_len;
    
    // 2. 최종 문자열을 저장할 메모리 동적 할당
    // total_length: 문자열 내용의 길이
    // + 1: 문자열의 끝을 알리는 null 종단 문자('\0')를 위한 공간
    char* answer = (char*)malloc(total_length + 1);
    
    // 메모리 할당 실패 체크 (선택 사항이지만 좋은 습관)
    if (answer == NULL) {
        return NULL; 
    }
    
    // 3. 배열 원소를 순회하며 문자들을 이어 붙임
    for (size_t i = 0; i < arr_len; i++) {
        // arr[i]는 길이 1의 문자열(예: "a")이므로, 
        // 문자열의 첫 번째 문자('a')를 answer의 i번째 위치에 복사합니다.
        // arr[i]는 char* 타입이며, arr[i][0]는 char 타입입니다.
        answer[i] = arr[i][0];
    }

    // 4. 문자열의 끝에 null 종단 문자('\0')를 삽입하여 문자열을 완성합니다.
    answer[total_length] = '\0';

    // 5. 동적 할당된 문자열 반환
    return answer;
}