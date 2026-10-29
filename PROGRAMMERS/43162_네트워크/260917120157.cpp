// PROGRAMMERS #43162 · 네트워크
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
// Language: cpp

#include <string>
#include <vector>
#include <queue>

using namespace std;
static int answer;
static vector<vector<int>> graph;
static vector<bool> visited;
static void bfs(vector<vector<int>>& graph,vector<bool>& visited, int n);

int solution(int n, vector<vector<int>> computers) {
    answer = 0;
    vector<vector<int>> graph(n);
    vector<bool> visited(n);
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(computers[i][j]==1 && j!=i){
                graph[i].push_back(j);   
            }
        }
    }
    for(int i=0; i<n; i++){
        if(visited[i]==false){
            bfs(graph,visited,i);
        }
    }
    
    return answer;
}

static void bfs(vector<vector<int>>& graph,vector<bool>& visited, int n){
    queue<int> q;
    q.push(n);
    while(!q.empty()){
        int k = q.front();
        visited[k]=true;
        q.pop();
        for(int i: graph[k]){
            if(visited[i]==false){
            q.push(i);
            }     
        }
    } 
    answer+=1;
}