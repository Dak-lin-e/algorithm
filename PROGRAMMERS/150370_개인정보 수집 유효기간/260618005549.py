# PROGRAMMERS #150370 · 개인정보 수집 유효기간
# https://school.programmers.co.kr/learn/courses/30/lessons/150370
# Language: python

# 날짜 문자열("YYYY.MM.DD")을 절대 일수(Integer)로 변환하는 마법의 함수
def date_to_days(date_str):
    year, month, day = map(int, date_str.split('.'))
    return (year * 12 * 28) + (month * 28) + day

def solution(today, terms, privacies):
    answer = []
    
    # 1. 오늘 날짜를 일수로 변환
    today_days = date_to_days(today)
    
    # 2. 약관 종류(terms)를 딕셔너리로 저장 (유효기간 달 수 -> 일수로 변환해서 저장)
    # 예: {"A": 6 * 28, "B": 12 * 28}
    term_dict = {}
    for term in terms:
        t_type, t_month = term.split()
        term_dict[t_type] = int(t_month) * 28
        
    # 3. 개인정보 수집 일자를 하나씩 돌면서 만료되었는지 확인
    for idx, privacy in enumerate(privacies):
        # 수집 일자와 약관 종류 분리
        collected_date, t_type = privacy.split()
        
        # 만료일 계산 = 수집된 날짜(일수) + 약관 유효기간(일수)
        expire_days = date_to_days(collected_date) + term_dict[t_type]
        
        # 오늘 날짜가 만료일과 같거나 더 지났다면 파기 대상! (인덱스는 1부터 시작하므로 +1)
        if today_days >= expire_days:
            answer.append(idx + 1)
            
    return answer