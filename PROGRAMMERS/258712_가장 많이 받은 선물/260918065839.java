// PROGRAMMERS #258712 · 가장 많이 받은 선물
// https://school.programmers.co.kr/learn/courses/30/lessons/258712
// Language: Java
// Execution Time: 63.17 ms
// Memory: 86.175 MB

import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n1 = friends.length;
        int n2 = gifts.length;
        
        // 이름별 인덱스 생성
        HashMap<String, Integer> check = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            check.put(friends[i], i);
        }
        
        // board[i][j]: i가 j에게 준 선물 횟수
        // points[i][0]: 준 선물 총 개수, points[i][1]: 받은 선물 총 개수, points[i][2]: 선물 지수
        int[][] board = new int[n1][n1]; 
        int[][] points = new int[n1][3];
        
        for (int j = 0; j < n2; j++) {
            String[] split1 = gifts[j].split(" ");
            int giver = check.get(split1[0]);
            int taker = check.get(split1[1]);
            
            board[giver][taker] += 1;
            points[giver][0] += 1; // 준 선물 증가
            points[taker][1] += 1; // 받은 선물 증가
        }
        
        // 선물지수 계산 (준 선물 - 받은 선물)
        for (int i = 0; i < n1; i++) {
            points[i][2] = points[i][0] - points[i][1];
        }
        
        // 다음달에 받을 선물 갯수 계산 배열 (정답 배열)
        int[] answer1 = new int[n1];
        
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                if (i == j) continue; // 자기 자신과의 비교는 스킵!
                
                // 1. i가 j보다 선물을 더 많이 준 경우
                if (board[i][j] > board[j][i]) {
                    answer1[i] += 1;
                }
                // 2. 주고받은 수가 같거나 둘 다 0개인 경우 -> 선물 지수 비교
                else if (board[i][j] == board[j][i]) {
                    if (points[i][2] > points[j][2]) {
                        answer1[i] += 1;
                    }
                }
            }
        }
        
        // 선물 최대 갯수 확인
        int max = 0;
        for (int k = 0; k < n1; k++) {
            if (answer1[k] > max) {
                max = answer1[k];
            }
        }
        
        return max;
    }
}