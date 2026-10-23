import java.util.*;
import java.io.*;

public class Main {
    public static int k,n;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void printanswer(){
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+ " ");
        }
        System.out.println();
    }

    public static void jaegui(int current){
        if(current==n){
            printanswer();
            return;
        }

        for(int i=1; i<=k; i++){
            answer.add(i);
            jaegui(current+1);
            answer.remove(answer.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        // Please write your code here.
        jaegui(0);
    }
}