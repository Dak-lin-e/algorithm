# SWEA #6308 · [파이썬 프로그래밍 기초(1) 파이썬의 기본 구조와 기초 문법] 9. 내장함수 1
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWcWB0Ua5SoDFAU4
# Language: Python
# Execution Time: 60 ms
# Memory: 51328 KB

from datetime import date

year=date.today().year-7
a=str(input().strip())
b=int(input())
c=100-b
print(f"{a}(은)는 {c+year}년에 100세가 될 것입니다.")