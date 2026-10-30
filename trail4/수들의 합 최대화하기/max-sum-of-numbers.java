import java.util.*;
import java.io.*;
public class Main {
    // static ArrayList<Integer> x;
    // static ArrayList<Integer> y;
    static int answer[][];
    static int grid[][];
    static int answer1;
    static int arr[];
    static int n;
    static boolean visited1[];
    static boolean visited2[];

    static void calculate(){
        int sum1 =0;
        for(int i=0; i<n; i++){
            sum1+= grid[answer[i][0]][answer[i][1]];    
        }
        if(sum1 > answer1){
            answer1=sum1;
        }
    }

    static void jaegui(int current){
        if(current == n){
        calculate();
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<2; j++){
        //         System.out.print(answer[i][j]);
        //     }    
        //         System.out.println();
        // }
            return;
        }

        for(int i=current; i<n; i++){
            if(!visited1[i]){
            visited1[i]=true;
            answer[i][0]=arr[i];
            
            for(int j=0; j<n; j++){
                if(!visited2[j]){
                visited2[j]=true;
                answer[i][1]=arr[j];
                jaegui(current+1);
                visited2[j]=false;
              //  answer[i][1]=0;
                }
                
            }
            //answer[i][0]=0;
            visited1[i]=false;
            }
        }
    return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=i;
        }
        answer = new int[n][2];
        answer1=0;
        visited1=new boolean[n];
        visited2=new boolean[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        jaegui(0);
        System.out.println(answer1);
        
    }
}