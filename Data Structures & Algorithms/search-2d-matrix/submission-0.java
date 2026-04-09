class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            int[] row=matrix[i];
            // for(int j=0;j<row.length;j++){
            // System.out.println(row[j]);
            // }
            // System.out.println("row done");
            if(target>=row[0] && target<=row[row.length-1]){
                int left=0,right=row.length-1;
                while(left<=right){
                int mid=left+(right-left)/2;
                if(row[mid]==target){
                    return true;
                }
                else if(target<row[mid]){
                right=mid-1;
                }
                else{
                    left=mid+1;
                }
                }
            }
        }
        return false;
    }
}
