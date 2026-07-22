class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        
        // 1. 1부터 rows * columns까지 숫자로 행렬 초기화
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        
        // 2. 각 쿼리마다 테두리 회전 수행
        for (int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1; // 0-based 인덱스로 변환
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;
            
            // 시작점 값 백업
            int temp = matrix[x1][y1];
            int minValue = temp;
            
            // 1. 왼쪽 테두리 위로 당기기 (아래 -> 위)
            for (int i = x1; i < x2; i++) {
                matrix[i][y1] = matrix[i + 1][y1];
                minValue = Math.min(minValue, matrix[i][y1]);
            }
            
            // 2. 아래쪽 테두리 왼쪽으로 당기기 (오른쪽 -> 왼쪽)
            for (int i = y1; i < y2; i++) {
                matrix[x2][i] = matrix[x2][i + 1];
                minValue = Math.min(minValue, matrix[x2][i]);
            }
            
            // 3. 오른쪽 테두리 아래로 당기기 (위 -> 아래)
            for (int i = x2; i > x1; i--) {
                matrix[i][y2] = matrix[i - 1][y2];
                minValue = Math.min(minValue, matrix[i][y2]);
            }
            
            // 4. 위쪽 테두리 오른쪽으로 당기기 (왼쪽 -> 오른쪽)
            for (int i = y2; i > y1 + 1; i--) {
                matrix[x1][i] = matrix[x1][i - 1];
                minValue = Math.min(minValue, matrix[x1][i]);
            }
            
            // 백업해둔 값을 올바른 자리(오른쪽 칸)에 넣기
            matrix[x1][y1 + 1] = temp;
            
            // 이번 쿼리에서 찾은 최솟값을 결과 배열에 저장
            answer[q] = minValue;
        }
        
        return answer;
    }
}