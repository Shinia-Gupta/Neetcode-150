class Solution {
    public int orangesRotting(int[][] grid) {
        //we are going to use multisource bfs here
        //what we will do is, add the indexes of all the rotten fruits in the queue.
        // for each rotten fruit we have in the queue, we need to elapse the time just once because at a particular minute, the neighboring fresh fruits of a rotten fruit will already get rotten. So we need to process the queue till queue size being contant and once the queue size is processed, we need to increase the number of elapsed minutes and check for the next level of bfs
        Queue<int[]> rottenFruits=new LinkedList<>();
int freshFruits=0;
        //add rotten fruits to queue
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==2){
                rottenFruits.add(new int[]{i,j});
            }

            if(grid[i][j]==1) freshFruits++;
        }
    }
    // if(rottenFruits.isEmpty()) return -1;
int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
int minutes=0;
    while(!rottenFruits.isEmpty() && freshFruits>0){
        for(int i=rottenFruits.size();i>0;i--){
        int[] rottenFruit=rottenFruits.poll();
for(int[] dir:directions){
    int newFruitRow=rottenFruit[0]+dir[0],newFruitCol=rottenFruit[1]+dir[1];
    if(newFruitRow<0||newFruitCol<0||newFruitRow>=grid.length||newFruitCol>=grid[0].length||grid[newFruitRow][newFruitCol]==0||grid[newFruitRow][newFruitCol]==2 ){
        continue;
    }
    freshFruits-=1;
    grid[newFruitRow][newFruitCol]=2;
    rottenFruits.add(new int[]{newFruitRow,newFruitCol});
}
        }

        //after one queue level completes, we have elapsed by 1 minute.
        // because at each queue level, we have simultaneously rotten the neighboring fruits of existing level
        minutes++;
    }
    return freshFruits==0?minutes:-1;
    }
}
