import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
    

    int dp[] = new int[n+1];

    dp[0]=1;

    for(int i =1; i<=n; i++){
        dp[i]+=dp[i-1];
        if(i-2>=0){
            dp[i]+=dp[i-2];
        }
        else{
            continue;
        }
        if(i-5>=0){
            dp[i]+=dp[i-5];
        }
    }
    System.out.println(dp[n]);
}
}