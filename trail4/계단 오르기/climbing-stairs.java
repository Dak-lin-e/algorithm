import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        
        // 각 층 별로 갈 수 있는 방법의 갯수를 저장하는 배열 
        int dp[] = new int[n+1];

        // 갈 수 없는 경우에는 INT_MIN으로 저장 , 점화식: dp[i] = Math.max(dp[i-1]+1 , dp[i]);
        for(int i=0; i<dp.length; i++){
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        if(n>=3){
            dp[3]=1;
            for(int i=4; i<n+1; i++){
                if(dp[i-2] != Integer.MIN_VALUE && dp[i-3] != Integer.MIN_VALUE){
                    dp[i]= Math.max(dp[i-2],dp[i-3]);
                    dp[i]+=1;
                }
                else if(dp[i-2] != Integer.MIN_VALUE || dp[i-3] != Integer.MIN_VALUE){
                    dp[i]= Math.max(dp[i-2],dp[i-3]);
                }
                else{
                }
            }
        }
        System.out.println(dp[n]);
    }
}