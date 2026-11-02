// SWEA #26956 · 행운의 구슬 팔찌
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpL76Hf3HBIQj
// Language: JAVA
// Execution Time: 103 ms
// Memory: 27392 KB

import java.util.*;

import java.io.*;



class Solution

{

public static void main(String args[]) throws Exception

{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

for(int test_case = 1; test_case <= T; test_case++)

{

            StringTokenizer st = new StringTokenizer(br.readLine());

    int[] nmk =new int[3];

            for(int i=0; i<3; i++){

                nmk[i]= Integer.parseInt(st.nextToken());

            }

            ArrayList<Integer> seq = new ArrayList<>();

            st= new StringTokenizer(br.readLine());



            for(int i=0; i<nmk[0]; i++){

                seq.add(i,Integer.parseInt(st.nextToken()));

            }

            int point=0;

            for(int i =0; i< nmk[2];i++){

                point += nmk[1];

                if(point >= seq.size()){

                  point = point % (seq.size()); 

                }

                if(point==0){

                seq.add((seq.get(seq.size()-1)+seq.get(point)));
                point = seq.size() - 1;

                }

                else{

                seq.add(point , (seq.get(point-1)+seq.get(point)));

                }

            }

           System.out.print("#" + test_case);

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