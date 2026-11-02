import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;
    int num;
    int dist;

    public Node(int x, int y, int num, int dist){
        this.x=x;
        this.y=y;
        this.num=num;
        this.dist=dist;
    }
}

public class Main {
    static int n,k;
    static int grid[][];
    static int r1,r2,c1,c2;
    static Deque<Node> answer = new ArrayDeque<>();
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    
    static boolean visited[][];
    // 거리를 저장할 리스트 생성
    static ArrayList<Integer> answer1 = new ArrayList<>();

    // 돌 위치 저장할 리스트 생성
    static ArrayList<Node> rocks = new ArrayList<>();

    // 부술 돌을 저장할 큐 생성
    static ArrayList<Node> destroyrocks = new ArrayList<>();

    // 거리 변수
    static int total;

    // 너비우선탐색
    static void bfs(){
        while(!answer.isEmpty()){
            Node n1 = answer.poll();
            if(n1.x == r2-1 && n1.y==c2-1){
                answer1.add(n1.dist);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = n1.x + dx[i];
                int ny = n1.y + dy[i];
                
                if (nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && grid[nx][ny]==0){
                        
                        visited[nx][ny]=true;
                        answer.add(new Node(nx,ny,grid[nx][ny],n1.dist+1));           
                }else{
                    nx=n1.x;
                    ny=n1.y;
                }
            }
            
        }
        answer1.add(-1);
        return;
        
    }

    // 돌 부수고 bfs 호출하는 함수
    static void destoryrocks(){
        for(int i=0; i<destroyrocks.size(); i++){
            Node n2 = destroyrocks.get(i);
            grid[n2.x][n2.y]=0;
        }
        visited = new boolean[n][n];
        answer.add(new Node(r1-1,c1-1,grid[r1-1][c1-1],0));
        bfs();
        
        for(int i=0; i<destroyrocks.size(); i++){
            Node n2 = destroyrocks.get(i);
            grid[n2.x][n2.y]=1;
        }
    }

    // 부숴야할 돌을 고르는 재귀함수
    static void dfs(int current){
        if(current == k){
            //System.out.println(destroyrocks.size());
            destoryrocks();
            return;
        }

        for(int i=current; i<rocks.size(); i++){
            destroyrocks.add(rocks.get(i));
            dfs(current+1);
            destroyrocks.remove(destroyrocks.size()-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==1){
                    rocks.add(new Node(i,j,grid[i][j],0));
                }
            }
        }

        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        
        // Please write your code here.
        dfs(0);

        int a = Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0; i<answer1.size(); i++){
            if(answer1.get(i)!= -1){
                flag=true;        
            }
        }

        if(flag){
            for(int i=0; i<answer1.size(); i++){
                if(a > answer1.get(i)&& answer1.get(i)!=-1){
                    a = answer1.get(i);
                }
            }
        }
        else{
            a=-1;
        }
        

        System.out.println(a);
    }
}