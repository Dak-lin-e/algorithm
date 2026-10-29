// PROGRAMMERS #12921 · 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/12921
// Language: java

class Solution {
    public int solution(int n) {
        int answer=0;
       boolean [] check = new boolean[n+1];
        check[0]=check[1]=true;
        for(int i=2;i*i<=n;i++){
                if (check[i]==true){
                    continue;
                }
            for(int j=i+i; j<=n;j+=i){
                check[j]=true;
            }
            }
        for(int i =0; i<n+1;i++){
            if(check[i]==false){
                answer+=1;
            }
        }
        return answer;
}}