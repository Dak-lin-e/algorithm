// SWEA #1873 · 상호의 배틀필드
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
// Language: Java
// Execution Time: 120 ms
// Memory: 31752 KB

import java.util.*;
import java.io.*;

class Solution
{
    static String map[][];
    static int x, y;
    static String current;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            map = new String[H][W];
            for(int i = 0; i < H; i++){
                String s1 = br.readLine();
                map[i] = s1.split("");
            }
            
            // 전차의 초기 위치와 방향 찾기
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                     if(!map[i][j].equals("*") && !map[i][j].equals("-") && !map[i][j].equals("#") && !map[i][j].equals(".")){
                         x = i;
                         y = j;
                         current = map[i][j];
                     }
                }
            }
            
            int c = Integer.parseInt(br.readLine().trim());
            String command = br.readLine().trim();
            String commandline[] = command.split("");
            
            for(String c1 : commandline) {
                // 1. 발사 (S)
                if(c1.equals("S")){
                    if(current.equals("<")){
                        for(int i = y; i >= 0; i--){
                            if(map[x][i].equals("*")){ // [수정] == 대신 equals 사용
                                map[x][i] = ".";
                                break;
                            } else if(map[x][i].equals("#")){ // 강철 벽을 만나면 포탄 소멸
                                break;
                            }
                        }
                    }
                    else if(current.equals(">")){
                        for(int i = y; i < W; i++){
                            if(map[x][i].equals("*")){
                                map[x][i] = ".";
                                break;
                            } else if(map[x][i].equals("#")){
                                break;
                            }
                        }
                    }
                    else if(current.equals("^")){
                        for(int i = x; i >= 0; i--){
                            if(map[i][y].equals("*")){
                                map[i][y] = ".";
                                break;
                            } else if(map[i][y].equals("#")){
                                break;
                            }
                        }
                    }
                    else if(current.equals("v")){
                        for(int i = x; i < H; i++){
                            if(map[i][y].equals("*")){
                                map[i][y] = ".";
                                break;
                            } else if(map[i][y].equals("#")){
                                break;
                            }
                        }
                    }           
                }
                // 2. 위로 이동 (U)
                else if (c1.equals("U")){
                    current = "^"; // [중요] 이동 여부와 상관없이 방향은 무조건 바뀜
                    if(x - 1 >= 0 && map[x - 1][y].equals(".")){
                        map[x][y] = ".";
                        x -= 1;
                    }
                    map[x][y] = current; // 최종 위치에 전차 모양 갱신
                }
                // 3. 아래로 이동 (D)
                else if (c1.equals("D")){
                    current = "v";
                    if(x + 1 < H && map[x + 1][y].equals(".")){
                        map[x][y] = ".";
                        x += 1;
                    }
                    map[x][y] = current;
                }
                // 4. 오른쪽으로 이동 (R)
                else if (c1.equals("R")){
                    current = ">";
                    if(y + 1 < W && map[x][y + 1].equals(".")){
                        map[x][y] = ".";
                        y += 1;
                    }
                    map[x][y] = current;
                }
                // 5. 왼쪽으로 이동 (L)
                else if (c1.equals("L")){
                    current = "<";
                    if(y - 1 >= 0 && map[x][y - 1].equals(".")){
                        map[x][y] = ".";
                        y -= 1;
                    }
                    map[x][y] = current;
                }    
            }
            
            // 결과 출력 구성
            sb.append("#").append(test_case).append(" ");
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    sb.append(map[i][j]);  // 문제 출력 형식에 맞게 공백 없이 붙여서 출력 (또는 문제에 따라 공백 처리)
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}