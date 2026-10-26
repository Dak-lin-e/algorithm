import java.util.*;
import java.io.*;

public class Main {
    static int n,r,c;
    static int num[][];
    static int moveDir[][];
    static boolean flag;
    static int answer1;
    // 1~9순서대로 방향배열
    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};

    static ArrayList<Integer> answer = new ArrayList<>();
 //   static boolean visited[][];

    public static void jaegui(int a, int b){
        flag=true;
        int d = moveDir[a][b]-1;
        // 더이상 갈 수 없는 경우 탐색 후 재귀함수 종료
        for(int i=1; i<n;i++){
            int nx = a+dx[d]*i;
            int ny = b+dy[d]*i;
            if(nx>=0 && nx<n && ny>=0 && ny<n && (num[a][b] > num[nx][ny])){
            }
            else if (nx>=0 && nx<n && ny>=0 && ny<n && num[a][b] < num[nx][ny]){
                flag=false;
                break;
            }      
        }
        if(flag){
            answer1=Math.max(answer1,answer.size());
            return;
        }

        for(int i=1; i<n;i++){
            int nx = (a)+dx[d]*i;
            int ny = (b)+dy[d]*i;
            if(nx>=0 && nx<n && ny>=0 && ny<n && num[a][b]< num[nx][ny]){
                //visited[nx][ny]=true;
                answer.add(num[nx][ny]);
                jaegui(nx,ny);
                //visited[nx][ny]=false;
                answer.remove(answer.size()-1);
            }
            else{
                nx=a;
                ny=b;
            }
        }
        return;        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        //visited= new boolean[n][n];
        answer1=0;
        //visited[r-1][c-1]=true;
        jaegui(r-1,c-1);
        System.out.println(answer1);

    }
}