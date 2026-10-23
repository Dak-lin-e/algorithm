import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> answer = new ArrayList<>();
    static int n,m;
    
    public static void printanswer(){
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }

    public static void jaegui(int current,int start){
        if(current == m){
            printanswer();
            return;
        }

        for(int i=start; i<=n; i++){
            answer.add(i);
            jaegui(current+1,i+1);
            answer.remove(answer.size()-1);
            }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.
        jaegui(0,1);
    
    }
}