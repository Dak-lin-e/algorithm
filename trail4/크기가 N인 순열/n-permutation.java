import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> answer = new ArrayList<>();
    static int n;
    static boolean visited[];
    public static void printanswer(){
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }

    public static void jaegui(int current){
        if(current ==n){
            printanswer();
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i-1]){
                answer.add(i);
                visited[i-1]=true;
                jaegui(current+1);
                answer.remove(answer.size()-1);
                visited[i-1]=false;
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        visited = new boolean[n];
        jaegui(0);
    }
}