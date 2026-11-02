// SWEA #26953 · 화물 입고 코드 점검
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpK9aHfHHBIQj
// Language: JAVA
// Execution Time: 125 ms
// Memory: 28888 KB

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{// 문자열을 담을 ArrayList 선언
        ArrayList<String> list1 = new ArrayList<>();
        
       // 문자열을 담을 ArrayList 선언 (문자 단위이므로 Character 또는 String 사용)        
        String s1 = br.readLine().trim(); // 입력받기
        
        // 한 글자씩 분리해서 ArrayList에 저장
        for (int i = 0; i < s1.length(); i++) {
            // char를 String으로 변환해서 넣고 싶다면 이렇게 작성합니다.
            list1.add(String.valueOf(s1.charAt(i)));
        }
          ArrayList<String> list2 = new ArrayList<>();
        
       // 문자열을 담을 ArrayList 선언 (문자 단위이므로 Character 또는 String 사용)        
        String s2 = br.readLine().trim(); // 입력받기
        
        // 한 글자씩 분리해서 ArrayList에 저장
        for (int i = 0; i < s2.length(); i++) {
            // char를 String으로 변환해서 넣고 싶다면 이렇게 작성합니다.
            list2.add(String.valueOf(s2.charAt(i)));
        }
         int []answer = new int [s1.length()];
         for(int i =0; i<s1.length(); i++){
         for(int j=0; j<s2.length(); j++){
         if(list1.get(i).equals(list2.get(j))){
         answer[i]+=1;
         }
         }
         }
      int max =0;
            for(int i=0; i<answer.length; i++){
            if(answer[i] > max){
            max = answer[i];
            }
            }
            
            System.out.println("#" + test_case + " " + max);
            
            
	}
}}