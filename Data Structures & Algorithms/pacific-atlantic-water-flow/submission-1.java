class Solution {

    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                boolean[][] visited = new boolean[m][n];

                boolean[] reach = dfs(heights, i, j, visited);

                if(reach[0] && reach[1]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private boolean[] dfs(int[][] heights, int r, int c, boolean[][] visited){

        int m = heights.length;
        int n = heights[0].length;

        visited[r][c] = true;

        boolean pacific = (r == 0 || c == 0);
        boolean atlantic = (r == m-1 || c == n-1);

        for(int[] dir : directions){

            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if(visited[nr][nc])
                continue;

            if(heights[nr][nc] > heights[r][c])
                continue;

            boolean[] next = dfs(heights, nr, nc, visited);

            pacific |= next[0];
            atlantic |= next[1];

            if(pacific && atlantic)
                return new boolean[]{true,true};
        }

        return new boolean[]{pacific, atlantic};
    }
}