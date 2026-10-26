-- PROGRAMMERS #284527 · 조건에 맞는 사원 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/284527
-- Language: MySQL

SELECT 
    SUM(g.SCORE) AS SCORE, 
    e.EMP_NO, 
    e.EMP_NAME, 
    e.POSITION, 
    e.EMAIL
FROM HR_EMPLOYEES e
JOIN HR_GRADE g ON e.EMP_NO = g.EMP_NO
WHERE g.YEAR = 2022
GROUP BY e.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;
