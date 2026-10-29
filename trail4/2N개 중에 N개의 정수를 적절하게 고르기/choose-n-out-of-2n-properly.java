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
        for(int c:arr){
            sum2.add(c);
        }

        // 2. sum1에 들어있는 요소들을 sum2에서 '값' 기준으로 하나씩 제거
        for(int i = 0; i < sum1.size(); i++){
        sum2.remove(Integer.valueOf(sum1.get(i)));
        }  // Integer.valueOf()를 써야 인덱스가 아니라 '값'을 찾아 딱 하나만 지웁니다.
        

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
        
        for(int i=current; i<2*n; i++){
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