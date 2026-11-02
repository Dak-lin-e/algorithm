// SWEA #26956 · 행운의 구슬 팔찌
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpL76Hf3HBIQj
// Language: JAVA
// Execution Time: 98 ms
// Memory: 27008 KB

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            ArrayList<Integer> seq = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                seq.add(Integer.parseInt(st.nextToken()));
            }
            
            int point = 0; // 첫 번째 작업 위치 (인덱스 0)
            
            for(int i = 0; i < K; i++){
                int standard = seq.get(0); // 맨 앞 구슬 (기준값)
                
                // 현재 작업 위치에서 M칸 앞으로 이동
                // 원형 구조이므로 (point + M) % 현재 리스트 크기
                point = (point + M) % seq.size();
                
                // 만약 point가 0이 되었다는 것은 줄의 끝을 지나 정확히 처음에 닿은 경우
                if(point == 0){
                    // 마지막 구슬 숫자 + 기준값
                    int newVal = seq.get(seq.size() - 1) + standard;
                    seq.add(newVal); // 맨 뒤에 추가
                    // 새로운 작업 위치는 방금 추가한 맨 뒤가 됨
                    point = seq.size() - 1;
                } else {
                    // 일반적인 경우: point 자리에 새 구슬 삽입 (바로 앞 칸 + 밀려나는 구슬)
                    int newVal = seq.get(point - 1) + seq.get(point);
                    seq.add(point, newVal);
                    // 새로 끼운 구슬이 다음 작업 위치가 됨 (point는 이미 그 자리를 가리킴)
                }
            }
            
            // 출력 형식 맞추기
            System.out.print("#" + test_case);
            
            // 마지막 구슬부터 거꾸로 뒤집기
            Collections.reverse(seq);
            
            // 구슬이 10개를 넘으면 마지막 10개까지만 출력
            int printCount = Math.min(10, seq.size());
            for(int i = 0; i < printCount; i++){
                System.out.print(" " + seq.get(i));
            }
            System.out.println();
        }
    }
}