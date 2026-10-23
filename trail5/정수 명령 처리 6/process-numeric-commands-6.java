import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
         // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();

            if(s1.equals("push")){
                int t = Integer.parseInt(st.nextToken());
                pq.add(t);
            }
            else if(s1.equals("pop")){
                System.out.println(pq.poll());
            }
            else if(s1.equals("empty")){
                if(pq.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(s1.equals("size")){
                System.out.println(pq.size());
            }
            else if(s1.equals("top")){
                System.out.println(pq.peek());
            }
        }
    }

    }
