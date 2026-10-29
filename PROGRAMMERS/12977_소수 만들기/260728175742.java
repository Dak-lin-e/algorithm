// PROGRAMMERS #12977 · 소수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// Language: java

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        
        // 1. 3개의 서로 다른 수를 고르는 3중 반복문
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    // 2. 합이 소수인지 판별
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    // 소수 판별 메서드
    private boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }
        return true;
    }
}