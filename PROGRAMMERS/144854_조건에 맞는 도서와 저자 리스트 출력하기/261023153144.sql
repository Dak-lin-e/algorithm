-- PROGRAMMERS #144854 · 조건에 맞는 도서와 저자 리스트 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144854
-- Language: MySQL

-- 코드를 입력하세요
SELECT b.BOOK_ID,a.AUTHOR_NAME,b.PUBLISHED_DATE FROM BOOK b LEFT JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID WHERE CATEGORY = "경제" ORDER BY b.PUBLISHED_DATE