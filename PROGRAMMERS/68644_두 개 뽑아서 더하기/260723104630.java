// PROGRAMMERS #68644 · 두 개 뽑아서 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/68644
// Language: java

import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set1 = new HashSet<>();
        int total =0;
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                
                total=numbers[i]+numbers[j];         
                set1.add(numbers[i]+numbers[j]);
            }
            
        }
        return set1.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}