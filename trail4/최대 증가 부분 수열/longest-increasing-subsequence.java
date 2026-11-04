import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int arr[];
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        dp[0]=1;
        for(int i=1; i < n; i++){
                if(arr[i]>arr[i-1]){
                    dp[i]=dp[i-1]+1;
                }else{
                    dp[i]=dp[i-1];
                }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<dp.length; i++){
            answer=Math.max(answer , dp[i]);
        }

        System.out.println(answer);
    
    }
}