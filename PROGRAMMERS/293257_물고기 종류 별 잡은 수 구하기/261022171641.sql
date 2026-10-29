-- PROGRAMMERS #293257 · 물고기 종류 별 잡은 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/293257
-- Language: MySQL

SELECT COUNT(ft.FISH_TYPE) AS FISH_COUNT ,f.FISH_NAME  FROM FISH_NAME_INFO f RIGHT JOIN  FISH_INFO ft ON f.FISH_TYPE=ft.FISH_TYPE GROUP BY ft.FISH_TYPE ORDER BY COUNT(ft.FISH_TYPE) DESC