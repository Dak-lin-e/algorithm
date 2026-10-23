import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;
    int num;
    int time;
    public Node(int x,int y, int num,int time){
        this.x = x;
        this.y = y;
        this.num = num;
        this.time = time;
    }

}

public class Main {
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    static int n,h,m;
    static Deque<Node> dq;
    static boolean visited[][];
    static int answer[][];
    static boolean flag;
    static Node startnode;
    static int a[][];

    public static void bfs(){
        
        while(!dq.isEmpty()){
            
            Node n1 = dq.poll();

            if(n1.num == 3){
                answer[startnode.x][startnode.y]=n1.time;
                flag=false;
                break;
            }

            for(int i=0; i<4;i++){
            
            int nx = n1.x + dx[i];
            int ny = n1.y + dy[i];
            
            if(nx>=0 && nx <n && ny>=0 && ny <n && !visited[nx][ny] && a[nx][ny] != 1 ){
                dq.add(new Node(nx,ny,a[nx][ny],n1.time+1));
                visited[nx][ny]=true;
            }
            else{
                nx=n1.x;
                ny=n1.y;
            }   
            }
        }

        if(flag){
            answer[startnode.x][startnode.y]=-1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        answer = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        // Please write your code here.

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(a[i][j]==2){
                    dq = new ArrayDeque<>();
                    visited=new boolean[n][n];
                    visited[i][j]=true;
                    flag=true;
                    startnode = new Node(i,j,a[i][j],0);
                    dq.add(new Node(i,j,a[i][j],0));
                    bfs();
                }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }


    }
}