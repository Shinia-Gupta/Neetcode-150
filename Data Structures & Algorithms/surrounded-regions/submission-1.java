class Solution {
    private static int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        //doubt 1- how would know whether i have encountered a continuous 4 directional connected group of Os
        //i thought that for any O, there should be exactly 2 neighboring Os and those O's should be 1 in a verical direction and one in a horizontal direction.
        // once i am confirm that it is a 4 directional O block, i can turn all indexes of it into X
        // but suppose there are multiple O blocks such that the 2 O blocks might share common neighbors of Os then if one block gets detected as 4D block, and i turn it into Xs, then the other block which too was going to get converted to Xs will be affected
        //for this, what i can do is, if an O block is detected, i store its indexes in a list. and once the entire board has been traversed for presence of O blocks, i will turn the indexes of the list into X
        //------------------------------------------------------------------------------------------------------------------------

        //safe cells
        //left col
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')
                dfs(board,i,0);
        } 
        
        //right col
        for(int i=0;i<board.length;i++){
            if(board[i][board[0].length-1]=='O')
                dfs(board,i,board[0].length-1);
        } 

        //top row
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O')
                dfs(board,0,i);
        } 

        //bottom row
        for(int i=0;i<board[0].length;i++){
            if(board[board.length-1][i]=='O')
                dfs(board,board.length-1,i);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='*') {
                    board[i][j]='O';
                    continue;
                }
                board[i][j]='X';
            }
        } 
    }

    private void dfs(char[][] board,int row,int col){
        board[row][col]='*';

        for(int[] dir:directions){
            int nr=row+dir[0],nc=col+dir[1];

            if(nr<0||nc<0||nr>board.length-1||nc>board[0].length-1||board[nr][nc]=='X'||board[nr][nc]=='*')
            continue;

            dfs(board,nr,nc);
        }
    }
}
