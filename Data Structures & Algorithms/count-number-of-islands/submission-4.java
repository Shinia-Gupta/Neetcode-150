class Solution {
    //bfs solution
    private static final int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int islands=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(grid,i,j);
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int row,int col){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{row,col});
        grid[row][col]='0';

        while(!q.isEmpty()){
            int[] cell=q.poll();
            int r=cell[0],c=cell[1];
            for(int[] dir:directions){
                int newRow=r+dir[0],newCol=c+dir[1];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]!='0' ){
                    grid[newRow][newCol]='0';
                    q.add(new int[]{newRow,newCol});
                }
            }
        }
    }
}
