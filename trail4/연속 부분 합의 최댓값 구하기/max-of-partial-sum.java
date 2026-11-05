import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int dp[]= new int[n];


        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            dp[i]=Integer.MIN_VALUE;
        }
        // Please write your code here.
        for(int i=0; i<n; i++){
            int total=0;
            for(int j=0; j<n-i; j++){
                total+=nums[i+j];
                dp[i] = Math.max(dp[i],total);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
           // System.out.println(dp[i]);
            if(dp[i]>ans){
                ans=dp[i];
            }
        }
        System.out.println(ans);
    }
}