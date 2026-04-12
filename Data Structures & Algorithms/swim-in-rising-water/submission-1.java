class Solution {
    public int swimInWater(int[][] grid) {
        //is it multisource bfs?...going from destination to source instead of source to destination
        
        
        //dfs bhi lag skta h direction traversal k liye...
        //fir har baar ek new minimum value set hogi based on the condition ki jo humari 
        //current minimum chl rha h, vo usse minimum ho...
        //har path pe hum ek minimum value set kr rhe honge along the path aur final minimum value set krdenge based on the current final minum and the minimum obtained from the path being traversed.
        //so that means, we will be having 2 minimums. one for the path and one is the final minimum

        int[] finalMinimum=new int[1];
        finalMinimum[0]=Integer.MAX_VALUE;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){

        //     }
        // }
dfs(0,0,grid.length-1,grid[0].length-1,visited,finalMinimum,grid[0][0],grid);
return finalMinimum[0];
    }

    private void dfs(int startRow, int startCol, int endRow,int endCol,boolean[][] visited,int[] finalMinimum,int currMinimum,int[][] grid){
        if(startRow<0||startCol<0||startRow>=grid.length||startCol>=grid[0].length|| visited[startRow][startCol]){
            return;
        }
       
        currMinimum=Math.max(grid[startRow][startCol],currMinimum);
       if(currMinimum>=finalMinimum[0]) return;

        if(startRow==endRow && startCol==endCol){
            finalMinimum[0]=currMinimum;
            return;
        }


        visited[startRow][startCol]=true;

        dfs(startRow+1,startCol,endRow,endCol,visited,finalMinimum,currMinimum,grid);
        dfs(startRow-1,startCol,endRow,endCol,visited,finalMinimum,currMinimum,grid);
        dfs(startRow,startCol+1,endRow,endCol,visited,finalMinimum,currMinimum,grid);
        dfs(startRow,startCol-1,endRow,endCol,visited,finalMinimum,currMinimum,grid);
        visited[startRow][startCol]=false;

    }
}
