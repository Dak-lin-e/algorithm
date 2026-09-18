def solution(message, spoiler_ranges):
    n = len(message)

    # 1. 각 위치가 몇 번째 스포 구간인지
    pos_to_range = [-1] * n
    for idx, (s, e) in enumerate(spoiler_ranges):
        for i in range(s, e + 1):
            pos_to_range[i] = idx

    # 2. 단어 파싱
    words = []  # (word, start, end)
    i = 0
    while i < n:
        if message[i] == ' ':
            i += 1
            continue
        s = i
        while i < n and message[i] != ' ':
            i += 1
        e = i - 1
        words.append((message[s:i], s, e))

    # 3. 단어별 등장 정보
    from collections import defaultdict
    occ = defaultdict(list)

    for w, s, e in words:
        occ[w].append((s, e))

    invalid = set()        # 완전히 비스포 등장 존재
    release_time = dict()  # 단어별 공개 시점

    for w, positions in occ.items():
        is_invalid = False
        min_release = float('inf')

        for s, e in positions:
            ranges = set()
            has_spoiler = False

            for i in range(s, e + 1):
                if pos_to_range[i] != -1:
                    has_spoiler = True
                    ranges.add(pos_to_range[i])

            # 완전히 비스포 → 탈락
            if not has_spoiler:
                is_invalid = True
                break

            # 이 등장 기준 공개 시점
            release = max(ranges)
            min_release = min(min_release, release)

        if is_invalid:
            invalid.add(w)
        else:
            release_time[w] = min_release

    # 4. 카운트
    counted = set()
    answer = 0

    # 구간 순서대로 처리
    for t in range(len(spoiler_ranges)):
        # 해당 시점에 공개되는 단어들
        current = []

        for w, rt in release_time.items():
            if rt == t:
                current.append(w)

        # 왼쪽 순서를 위해 등장 순서대로 처리
        # words 기준으로 순회
        for w, s, e in words:
            if w in current:
                if w in counted:
                    continue
                if w in invalid:
                    continue

                counted.add(w)
                answer += 1

    return answer