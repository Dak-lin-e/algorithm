-- PROGRAMMERS #284531 · 노선별 평균 역 사이 거리 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/284531
-- Language: MySQL

SELECT 
    ROUTE,
    -- 총 누계 거리 계산 (소수점 둘째 자리에서 반올림 후 'km' 추가)
    CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE,
    -- 평균 역 사이 거리 계산 (소수점 셋째 자리에서 반올림 후 'km' 추가)
    CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
FROM 
    SUBWAY_DISTANCE
GROUP BY 
    ROUTE
ORDER BY 
    TOTAL_DISTANCE DESC;