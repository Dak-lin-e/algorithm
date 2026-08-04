import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // [포인트 1] answer는 반드시 테스트 케이스마다 1로 초기화되어야 합니다!
            int answer = 1;
            
            String s1 = br.readLine();
            String[] list1 = s1.split("");
            ArrayList<String> list2 = new ArrayList<>();
            
            for(int i = 0; i < list1.length; i++){
                if(list1[i].equals("{") || list1[i].equals("(")) {
                    list2.add(list1[i]);
                }
                else if(list1[i].equals("}")) {
                    // [포인트 2] remove 하기 전에 비어있는지 먼저 체크해야 에러가 안 납니다!
                    if(list2.isEmpty() || !list2.remove(list2.size() - 1).equals("{")) {
                        answer = 0;
                        break;
                    }
                }
                else if(list1[i].equals(")")) {
                    if(list2.isEmpty() || !list2.remove(list2.size() - 1).equals("(")) {
                        answer = 0;
                        break;
                    }
                }
            }
            
            // [포인트 3] 문자열을 다 돌았는데도 여는 괄호가 남아있다면 틀린 것
            if(answer == 1 && !list2.isEmpty()) {
                answer = 0;
            }
            
            System.out.println("#" + test_case + " " + answer);
        }
    }
}