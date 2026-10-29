# PROGRAMMERS #120875 · 평행
# https://school.programmers.co.kr/learn/courses/30/lessons/120875
# Language: python

def solution(dots):
    # 두 점을 연결했을 때의 기울기를 구하는 함수
    def get_slope(p1, p2):
        if p1[0] == p2[0]:  # x 좌표가 같으면 기울기는 무한대 (수직선)
            return float('inf')
        return (p2[1] - p1[1]) / (p2[0] - p1[0])

    # 가능한 모든 선의 기울기 비교 (4가지 조합)
    if get_slope(dots[0], dots[1]) == get_slope(dots[2], dots[3]):
        return 1
    if get_slope(dots[0], dots[2]) == get_slope(dots[1], dots[3]):
        return 1
    if get_slope(dots[0], dots[3]) == get_slope(dots[1], dots[2]):
        return 1

    return 0