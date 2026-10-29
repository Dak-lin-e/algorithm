// PROGRAMMERS #49993 · 스킬트리
// https://school.programmers.co.kr/learn/courses/30/lessons/49993
// Language: java

import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s1 : skill_trees){
            char check[]= new char[skill.length()];
            Deque<String> d =new ArrayDeque<>();
            
            Collections.addAll(d,skill.split(""));
            
            String s3[]= s1.split("");
            boolean flag=true;
            for(String s4:s3){
                
                if(d.contains(s4)){
                    String s2 = d.peek();
                    if(s2.equals(s4)){
                        d.poll();                    
                    }
                    else{
                        flag=false;
                    }
                }
            }
            if(flag){
                answer+=1;
            }
            
        }
        
        return answer;
    }
}