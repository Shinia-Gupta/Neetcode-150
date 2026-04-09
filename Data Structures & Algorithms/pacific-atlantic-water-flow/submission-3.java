class Solution {
    //destination to source approach
    private static int directions[][]={{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean pacific[][]=new boolean[n][m];
        boolean atlantic[][]=new boolean[n][m];

        //pacific left border
        for(int i=0;i<pacific.length;i++){
            dfs(heights,pacific,i,0);
        }
        //pacific top border
        for(int j=0;j<pacific[0].length;j++){
            dfs(heights,pacific,0,j);
        }
        
        //atlantic right border
        for(int i=0;i<atlantic.length;i++){
            dfs(heights,atlantic,i,heights[0].length-1);
        }
        //atlantic bottom border
        for(int j=0;j<atlantic[0].length;j++){
            dfs(heights,atlantic,heights.length-1,j);
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights,boolean[][] visited,int row,int col){
        visited[row][col]=true;

        for(int dir[]:directions){
            int newRow=row+dir[0],newCol=col+dir[1];

            if(newRow<0||newCol<0||newRow>=heights.length||newCol>=heights[0].length||visited[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol]<heights[row][col]){
                continue;
            }

            dfs(heights,visited,newRow,newCol);
        }

    }
}
