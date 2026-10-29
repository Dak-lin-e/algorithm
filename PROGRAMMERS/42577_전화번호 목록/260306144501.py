# PROGRAMMERS #42577 · 전화번호 목록
# https://school.programmers.co.kr/learn/courses/30/lessons/42577
# Language: python

def solution(phone_book):
    # 1. 모든 전화번호를 해시 맵(딕셔너리)에 키(key)로 등록합니다.
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
        
    # 2. 다시 전화번호를 하나씩 꺼내서 접두어 검사를 합니다.
    for phone_number in phone_book:
        prefix = ""
        # 전화번호를 한 글자씩 붙여가며 접두어를 만듭니다. (마지막 글자 제외)
        # 예: "119"라면 "1", "11"까지만 확인
        for char in phone_number[:-1]:
            prefix += char
            # 3. 만들어진 접두어가 해시 맵의 키로 존재한다면 접두어인 번호가 있다는 뜻!
            if prefix in hash_map:
                return False
                
    # 4. 끝까지 겹치는 게 없었다면 True 반환
    return True