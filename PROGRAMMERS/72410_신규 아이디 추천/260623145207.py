# PROGRAMMERS #72410 · 신규 아이디 추천
# https://school.programmers.co.kr/learn/courses/30/lessons/72410
# Language: python

def solution(new_id):
    # 1단계: 소문자 변환
    new_id = new_id.lower()
    
    # 2단계: 알파벳, 숫자, '-', '_', '.'를 제외한 모든 문자 제거
    # (조건에서 허용한 '-', '_', '.'은 지우는 목록에서 제외해야 합니다)
    for k in '~!@#$%^&*()=+[{]}:?,<>/':
        new_id = new_id.replace(k, '')
        
    # 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표로 치환
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
    
    # 4단계: 마침표(.)가 처음이나 끝에 위치하면 제거
    # (인덱스 에러를 막기 위해 startswith, endswith나 슬라이싱을 씁니다)
    if new_id.startswith('.'):
        new_id = new_id[1:]
    if new_id.endswith('.'):
        new_id = new_id[:-1]
        
    # 5단계: 빈 문자열이라면, new_id에 "a"를 대입
    if not new_id:
        new_id = 'a'
        
    # 6단계: 길이가 16자 이상이면, 첫 15개 문자만 남김
    if len(new_id) >= 16:
        new_id = new_id[:15]  # 15자만 남겨야 하므로 :15 입니다.
        if new_id.endswith('.'):
            new_id = new_id[:-1]
            
    # 7단계: 길이가 2자 이하인 경우
    elif len(new_id) <= 2:
        while len(new_id) < 3:
            new_id += new_id[-1]
            
    return new_id
