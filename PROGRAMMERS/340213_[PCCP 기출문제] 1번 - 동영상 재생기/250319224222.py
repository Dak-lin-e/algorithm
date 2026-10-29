# PROGRAMMERS #340213 · [PCCP 기출문제] 1번 / 동영상 재생기
# https://school.programmers.co.kr/learn/courses/30/lessons/340213
# Language: python

def solution(video_len, pos, op_start, op_end, commands):
    # "mm:ss" -> 초(second) 변환 함수
    def time_to_seconds(time_str):
        mm, ss = map(int, time_str.split(":"))
        return mm * 60 + ss

    # 초(second) -> "mm:ss" 변환 함수
    def seconds_to_time(seconds):
        mm, ss = divmod(seconds, 60)
        return f"{mm:02}:{ss:02}"  # 두 자리 숫자로 반환

    # 동영상 길이, 현재 재생 위치, 오프닝 구간을 초 단위로 변환
    total_length = time_to_seconds(video_len)
    current_pos = time_to_seconds(pos)
    op_start_sec = time_to_seconds(op_start)
    op_end_sec = time_to_seconds(op_end)

    # 현재 위치가 오프닝 구간이라면 오프닝 끝나는 위치로 이동
    if op_start_sec <= current_pos <= op_end_sec:
        current_pos = op_end_sec

    # 명령어 처리
    for command in commands:
        if command == "prev":
            current_pos = max(0, current_pos - 10)  # 10초 전 이동 (최소 0초)
        elif command == "next":
            current_pos = min(total_length, current_pos + 10)  # 10초 후 이동 (최대 동영상 길이)

        # 이동 후 오프닝 구간 체크
        if op_start_sec <= current_pos <= op_end_sec:
            current_pos = op_end_sec  # 오프닝 끝나는 위치로 이동

    # 최종 위치를 "mm:ss" 형식으로 반환
    return seconds_to_time(current_pos)
