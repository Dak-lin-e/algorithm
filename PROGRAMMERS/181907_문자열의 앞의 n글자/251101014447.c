// PROGRAMMERS #181907 · 문자열의 앞의 n글자
// https://school.programmers.co.kr/learn/courses/30/lessons/181907
// Language: c

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h> // strlen 사용하지 않지만, 일반적으로 필요할 수 있음

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, int n) {

    // 🌟 변수 선언 추가
    int i; 

    // 🌟 널 문자를 위해 (n + 1) 크기로 메모리 할당
    char* answer = (char*)malloc(sizeof(char) * (n + 1));
    
    // 🌟 할당 실패 체크 시 'answer' 변수를 사용
    if (answer == NULL) {
        // 메모리 할당 실패 시 오류 처리 (exit(1)은 테스트 환경에서 부적절할 수 있으므로, NULL 반환 권장)
        // exit(1); 
        return NULL; 
    }
    
    // my_string의 앞 n개의 문자를 복사
    for (i = 0; i < n; i++) {
        // 복사하려는 n이 my_string의 실제 길이보다 길 경우를 대비한 안전성 체크는 추가적으로 필요합니다.
        answer[i] = my_string[i];
    }
    
    // 널 종단 문자 삽입 (n번째 인덱스)
    answer[n] = '\0'; 
    
    return answer;
}