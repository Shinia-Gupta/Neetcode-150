class Solution {
    //multi-source bfs approach 
    //tc=m*n
    //sc=m*n
    
        private static int INF=2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> nodes=new LinkedList<>();
        //add all treasure cells to the queue
        for(int i=0;i<grid.length;i++){//tc=m*n
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    nodes.add(new int[]{i,j});
                }
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        //start traversing the neighbors
        while(!nodes.isEmpty()){
            int[] currCell=nodes.poll();
            int currRow=currCell[0],currCol=currCell[1];
            for(int[] dir:directions){//4 directions traversed for each valid cell - so tc=O(1) as there is a boundary check for invalid cell too.The cell is not processed more than once if it has already got its distance value. So it eliminates the need for an extra visited matrix. So sc=O(m*n) for queue in worst case if majority cells are valid
                int neighborCellRow=currRow+dir[0],neighborCellCol=currCol+dir[1];

                //if not valid cell
                if(neighborCellRow<0||neighborCellCol<0||neighborCellRow>=grid.length||neighborCellCol>=grid[0].length||grid[neighborCellRow][neighborCellCol]!=INF){
                    continue;
                }
                
                //add the new valid neighbor cell to the queue
                nodes.add(new int[]{neighborCellRow,neighborCellCol});

                //and update the distance of the new valid cell with the parent cell's value+1
                grid[neighborCellRow][neighborCellCol]=grid[currRow][currCol]+1;
            }
        }
    }
}
