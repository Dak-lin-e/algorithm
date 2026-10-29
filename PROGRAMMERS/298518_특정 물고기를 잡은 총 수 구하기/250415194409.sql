-- PROGRAMMERS #298518 · 특정 물고기를 잡은 총 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/298518
-- Language: MySQL

-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE FISH_TYPE IN(SELECT FISH_TYPE
                  FROM FISH_NAME_INFO
                  WHERE FISH_NAME IN('BASS','SNAPPER')
                   );