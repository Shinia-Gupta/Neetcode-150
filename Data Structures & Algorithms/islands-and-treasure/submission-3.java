class Solution {
        private static final int INF=2147483647;
        private static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==INF){
                    grid[i][j]=bfs(grid,i,j);
                }
            }
        }
    }

    private int bfs(int[][] grid, int row,int col){
Queue<int[]> pathsToTraverseTillTreasure=new LinkedList<>();
boolean[][] visited=new boolean[grid.length][grid[0].length];
pathsToTraverseTillTreasure.add(new int[]{row,col});
visited[row][col]=true;
int steps=0;
while(!pathsToTraverseTillTreasure.isEmpty()){
    
for(int i=pathsToTraverseTillTreasure.size()-1;i>=0;i--){
    int[] currCell=pathsToTraverseTillTreasure.poll();
    
    int r=currCell[0],c=currCell[1];
    if(grid[r][c]==0) return steps;
    for(int[] dir:directions){
    int newRow=r+dir[0],newCol=c+dir[1];
    if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && visited[newRow][newCol]==false && grid[newRow][newCol]!=-1){
        visited[newRow][newCol]=true;
        pathsToTraverseTillTreasure.add(new int[]{newRow,newCol});

    }
    }
}
steps++;
}
return INF;
    }
}


