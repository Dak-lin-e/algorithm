// SWEA #26944 · 이삿짐 상자 나르기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpH8aHc3HBIQj
// Language: JAVA
// Execution Time: 91 ms
// Memory: 27136 KB

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int []nm = new int[2];
            for(int i=0; i < 2; i++){
                nm[i] = Integer.parseInt(st.nextToken());
            }
            // deque 생성 후 값 삽입 후 정렬까지
            Deque <Integer> boxes = new ArrayDeque<Integer>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i < nm[0]; i++){
                boxes.add(Integer.parseInt(st.nextToken()));
            }
            List <Integer> boxtemp = new ArrayList<>(boxes);
            Collections.sort(boxtemp, Collections.reverseOrder());
            Deque <Integer> realboxes = new ArrayDeque<Integer>(boxtemp);
            
            // deque 생성 후 값 삽입 후 정렬까지 
            Deque <Integer> workers = new ArrayDeque<Integer>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i < nm[1]; i++){
                workers.add(Integer.parseInt(st.nextToken()));
            }
            List<Integer> worktemp = new ArrayList<>(workers);
            Collections.sort(worktemp, Collections.reverseOrder());
            Deque<Integer> realworkers= new ArrayDeque<Integer>(worktemp);
            // 더 짧은 deque를 반복문의 길이로  설정. while 문 사용시 무한루프에 빠져버림.
            int answer=0;
            int b= realboxes.size();
            int w= realworkers.size();
            int n;
            if(b>=w){
                n=w;
            }
            else{
                n=b;
            }
            while(!realboxes.isEmpty() && !realworkers.isEmpty()){
                if (realworkers.peekFirst() >= realboxes.peekFirst()){
                    answer+=realboxes.pollFirst();
                    realworkers.pollFirst();
                }
                else{
                    realboxes.pollFirst();                
                }
            }
            System.out.println("#"+test_case + " "+answer);

		}
	}
}