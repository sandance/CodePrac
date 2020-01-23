class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return false;
    
    int row = matrix.length;
    int col = matrix[0].length;
    
    int start;
    int end;
    int mid;
    int mid_val;

    for(int i = 0; i < row; i++){
        if(matrix[i][0] <= target && matrix[i][col - 1] >= target){
            start = 0;
            end = col - 1;
            
            while(start <= end){
                mid = (start + end) / 2;
                mid_val = matrix[i][mid];
                if(mid_val == target)
                    return true;
                else if(mid_val > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }   
    }
    return false;
    
    }
}