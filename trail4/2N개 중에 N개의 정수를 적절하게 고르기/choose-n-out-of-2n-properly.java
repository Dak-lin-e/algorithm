import java.util.*;
import java.io.*;
public class Main {
    static int n ;
    static int arr[];
    static ArrayList<Integer> sum1;
    static ArrayList<Integer> sum2;
    static int answer ;

    static void calculate(){
        sum2 = new ArrayList<>();
        for(int i=0; i<2*n; i++){
            if(!sum1.contains(arr[i])){
                sum2.add(arr[i]);
            }
        }

        int total1=0;
        int total2=0;
        for(int i=0; i<n; i++){
            total1+=sum1.get(i);
            total2+=sum2.get(i);
        }
        



        if( answer > Math.abs(total1-total2)){
            answer = Math.abs(total1-total2);
        }

    }

    static void jaegui(int current){
        if(sum1.size() == n){
            calculate();
            return ;
        }
        
        for(int i=current; i<2*n-1; i++){
            sum1.add(arr[i]);
            jaegui(i+1);
            sum1.remove(sum1.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];

        sum1 = new ArrayList<>();
     //   sum2 = new ArrayList<>();

        answer = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        jaegui(0);
        System.out.print(answer);
    
    }
}