# SWEA #1240 · [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15FZuqAL4CFAYD
# Language: Python
# Execution Time: 64 ms
# Memory: 54144 KB

def test(list1):
    # 딕셔너리 키를 '문자열'로 다루기 위해 변경 (가독성을 위해 key-value 위치를 바꾸는 게 편합니다)
    check = {
        "0001101": 0, "0011001": 1, "0010011": 2, "0111101": 3, "0100011": 4,
        "0110001": 5, "0101111": 6, "0111011": 7, "0110111": 8, "0001011": 9
    }
    
    answer1 = []
    real_code = []
    
    for row in list1:
        # 문자로 처리하기 때문에 '1'이 포함되어 있는지 확인
        if '1' in row:
            # 1. 안전하게 역순 리스트 생성 (In-place reverse 대신 슬라이싱 사용)
            reversed_list = row[::-1]
            index1 = reversed_list.index('1')
            
            # 2. 뒤집힌 상태에서 56칸을 가져온 뒤, 다시 정상 방향으로 뒤집기
            code = reversed_list[index1:index1+56]
            real_code = code[::-1]
            break # 코드를 찾았으면 다른 행은 더 볼 필요가 없습니다.
            
    # while 루프를 if/for 블록과 연계되도록 정렬
    while len(real_code) != 0:
        # 3. 8칸이 아니라 '7칸'씩 슬라이싱 해야 합니다!
        slice1 = "".join(real_code[:7]) 
        real_code = real_code[7:]
        
        if slice1 in check:
            answer1.append(check[slice1])
            
    # answer1 자체가 이미 정수 리스트이므로 변환 과정 생략 가능
    total_h = 0  # 홀수 번째 자리 (인덱스로는 0, 2, 4, 6)
    total_j = 0  # 짝수 번째 자리 (인덱스로는 1, 3, 5, 7)
    
    for j, k in enumerate(answer1):
        if j % 2 == 0:  # 인덱스 0, 2, 4, 6 -> 1, 3, 5, 7번째 자리
            total_h += k
        else:           # 인덱스 1, 3, 5, 7 -> 2, 4, 6, 8번째 자리
            total_j += k
            
    # 4. 검증 공식 대입
    if (total_h * 3 + total_j) % 10 == 0:
        return sum(answer1)
    else:
        return 0

T = int(input())
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    list1 = []
    for i in range(a):
        # 5. 공백이 없으므로 split() 대신 list(input().strip())으로 글자 하나씩 쪼개어 입력받음
        list1.append(list(input().strip()))
        
    # [주의] answer 계산과 출력은 행을 다 입력받은 후(for문 밖에서) 수행해야 합니다.
    answer = test(list1)
    print(f"#{test_case} {answer}")