import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer,Integer> hm = new HashMap<>();
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            if(s1.equals("add")){
                int t = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());

                hm.put(t,u);
            }
            else if(s1.equals("find")){
                int t = Integer.parseInt(st.nextToken());
                if(hm.containsKey(t)){
                    System.out.println(hm.get(t));
                }
                else{
                    System.out.println("None");
                }
            }
            else if(s1.equals("remove")){
                int t = Integer.parseInt(st.nextToken());
                hm.remove(t);
            }
        }
    }
}