class Solution {
    //1. static variables maintain their values acroos all the test cases. So if Test case 1 had expected output of 50 and test case 2 had expected output of 24, then testcase2 will again return 50 instead of 24 while running the program as the program will take the max of maxLand and currLand. so max of 50 and 24 will be 50 again.
    // private static int maxLand=0;
    //2. now the second issue- suppose there is a + shaped island so expected output should be 5, but the currLand value being passed to the branches is a copy and not shared commonly by all the branches, so the output of this land will be 3 i.e. top vertical branch node,then middle land node,then bottom land node
    public int maxAreaOfIsland(int[][] grid) {
        int maxLand=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   maxLand=Math.max(maxLand,dfs(i,j,grid,0));
                }
            }
        }
        return maxLand;
    }

    private int dfs(int row,int col,int[][] grid,int currLand){
        if(row<0||col<0||row>=grid.length||col>=grid[row].length||grid[row][col]==0){
            return 0;
        }
        //no maxLand updation 
        // maxLand=Math.max(maxLand,currLand);
        grid[row][col]=0;

        //traversal in directions
       int down= dfs(row+1,col,grid,currLand);
       int up= dfs(row-1,col,grid,currLand);        
       int right= dfs(row,col+1,grid,currLand);
       int left= dfs(row,col-1,grid,currLand);
        return 1+down+up+right+left;
    }
}
