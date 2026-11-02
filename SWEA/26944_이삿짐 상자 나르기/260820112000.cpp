// SWEA #26944 · 이삿짐 상자 나르기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpH8aHc3HBIQj
// Language: C++
// Execution Time: 7 ms
// Memory: 5848 KB

#include<iostream>
#include<deque>
#include<algorithm>
#include<vector>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
    cin >>T;
	for(test_case = 1; test_case <= T; test_case++)
	{
        int N,M;
        cin >> N >>M;
        vector<int> boxes(N);
        for(int i=0; i<N; i++){
             cin>>boxes[i];
        }
        sort(boxes.begin() ,boxes.end(), greater<int>());
        deque<int> realboxes(boxes.begin(),boxes.end());
        
        vector<int> workers(M);
        for(int i=0; i<M; i++){
             cin>>workers[i];
        }
        sort(workers.begin() ,workers.end(), greater<int>());
        deque<int> realworkers(workers.begin(), workers.end());
        
        int answer=0;
        while(!realboxes.empty() && !realworkers.empty()){
             if(realworkers.front() >= realboxes.front()){
                  answer += realboxes.front();
                  realboxes.pop_front();
                  realworkers.pop_front();
             }
            else{
                 realboxes.pop_front();
            }
        }
        cout<<"#"<< test_case <<" " << answer<<"\n"; 
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
