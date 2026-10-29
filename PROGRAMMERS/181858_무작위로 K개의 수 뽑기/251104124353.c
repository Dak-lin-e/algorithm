// PROGRAMMERS #181858 · 무작위로 K개의 수 뽑기
// https://school.programmers.co.kr/learn/courses/30/lessons/181858
// Language: c

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
// K는 찾아야 할 고유 요소의 개수입니다.
int* solution(int arr[], size_t arr_len, int k) {
    
    // 1. 반환 배열(answer) 할당: K개의 요소를 저장할 공간 확보
    int* answer = (int*)malloc(sizeof(int) * k);
    if (answer == NULL) {
        return NULL; // 메모리 할당 실패 처리
    }
    
    int count = 0; // answer에 현재까지 저장된 고유 요소의 개수 (answer의 인덱스 역할)
    
    // 2. arr 배열을 순회하며 고유 요소 찾기
    for (size_t i = 0; i < arr_len; i++) {
        
        // 목표 개수 K개를 모두 찾았으면 반복 중단
        if (count == k) {
            break;
        }
        
        // 현재 arr[i] 값이 answer 배열에 이미 존재하는지 확인 (중복 체크)
        bool is_duplicate = false;
        
        // answer 배열에 저장된 count 개수만큼만 순회하며 검사
        for (int j = 0; j < count; j++) { 
            if (arr[i] == answer[j]) {
                is_duplicate = true;
                break; // 중복 발견 시 즉시 내부 루프 탈출
            }
        }
        
        // 3. 중복이 아니면 answer에 저장하고 count 증가
        if (!is_duplicate) {
            answer[count] = arr[i];
            count++;
        }
    }
    
    // 4. 남은 공간이 있으면 -1로 채우기
    // count는 현재까지 채워진 요소 개수이므로, count부터 k-1까지 -1로 채웁니다.
    for (int p = count; p < k; p++) {
        answer[p] = -1;
    }
    
    return answer;
}