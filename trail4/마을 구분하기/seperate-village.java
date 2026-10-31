import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int grid[][];
    static int total;
    static int sum;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean visited[][];
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};

    static void jaegui(int x,int y){
        for(int i=0; i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >=0 && nx<n && ny >=0 && ny<n && !visited[nx][ny]&& grid[nx][ny]==1){
            visited[nx][ny]=true;
            sum+=1;
            jaegui(nx,ny);
        }
        else{
            nx=x;
            ny=y;
        }
        }

        return;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited= new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    total+=1;
                    sum=1;
                    visited[i][j]=true;
                    jaegui(i,j);
                    if(sum!=0){
                        answer.add(sum);
                    }
                }
            }
        }
        Collections.sort(answer);
        System.out.println(total);
        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    
    }

}