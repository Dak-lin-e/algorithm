import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n+1];
        int dp[]= new int[m+1];
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <=n; i++){
            coin[i] = sc.nextInt();
            }
        // Please write your code here.
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;

        for(int i=1; i<=m; i++){
            int temp=Integer.MAX_VALUE;
            for(int j=1; j<=n; j++){
                if(i>=coin[j]){
                    if(dp[i-coin[j]]==Integer.MIN_VALUE){
                        continue;
                    }
                    if(i==m ){
                    answer.add(dp[i-coin[j]]+1);
                    }
                    else{
                    if(temp>dp[i-coin[j]]+1){
                        temp=dp[i-coin[j]]+1;
                        dp[i]=temp;
                    }
                    }
                }
            }
        }

        int ans=Integer.MAX_VALUE;
        
        for(int a:answer){
            //System.out.println(a);
            if(ans>a){
                ans=a;
            }
        }

        if(ans==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
        System.out.println(ans);
        }

        }
    }
