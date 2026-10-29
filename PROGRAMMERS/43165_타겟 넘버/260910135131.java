// PROGRAMMERS #43165 · 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// Language: java

class Solution {
    static int[] numberss;
    static int targets;
    static int answer;
    public int solution(int[] numbers, int target) {
        numberss= numbers.clone();
        targets = target;
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int i, int n){
        if(i==numberss.length){
           if(targets == n){
               answer++;
           }
            return;
        }
        else{
        int n1 = numberss[i];
        dfs(i+1,n+n1);
        dfs(i+1,n-n1);
            }
    }
    
        
        
    }
