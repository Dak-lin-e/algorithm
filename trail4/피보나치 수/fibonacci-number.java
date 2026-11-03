import java.util.Scanner;
public class Main {

    static int fibo(int n){
        if(n<=2){
            return 1;
        }

        else{
            return fibo(n-1) + fibo(n-2);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        System.out.println(fibo(n));
    }
}