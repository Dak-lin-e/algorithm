import java.util.Scanner;
public class Main {
    static int memo[];
    static int n;
    static int fibo(int num){
        if(memo[num] != 0){
            return memo[num];
        }

        if(num<=2){
            memo[num]=1;
        }

        else{
            memo[num]=fibo(num-1) + fibo(num-2);
        }
        return memo[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        memo = new int[n+1];
        System.out.println(fibo(n));
    }
}