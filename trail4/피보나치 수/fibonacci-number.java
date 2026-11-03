import java.util.Scanner;
public class Main {
    static int memeo[];

    static int fibo(int n){
        if(memo[n] != -1){
            return memo[n];
        }
        if(n<=2){
            memo[n]=1;
            return 1;
        }

        else{
            memo[n]=fibo(n-1) + fibo(n-2);
            return memo[n];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        memo = new int[n];
        System.out.println(fibo(n));
    }
}