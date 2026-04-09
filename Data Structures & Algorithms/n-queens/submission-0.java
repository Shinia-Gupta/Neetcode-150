class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(res,0,board);
        
        return res;
    }

    private void backtrack(List<List<String>> res,int row,char[][] board){
        if(row==board.length){
            res.add(new ArrayList<>(construct(board)));
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isValidPos(row,col,board)){
                board[row][col]='Q';
                backtrack(res,row+1,board);
                board[row][col]='.';
            }
        }
    }

    private List<String> construct(char[][] board){
        List<String> sublist=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder str=new StringBuilder();
            for(int j=0;j<board[i].length;j++){
                str.append(board[i][j]);
            }
            sublist.add(str.toString());
        }
        return sublist;
    }

    private boolean isValidPos(int row,int col,char[][] board){
        //horizontal check - not required 
        // - because we are already checking the position for each column for vertical, left diagonal and right diagonal 
        // for(int i=0;i<=col;i++){
        //     if(board[row][i]=='Q') return false;
        // }

        //vertical check
        for(int i=0;i<=row;i++){
            if(board[i][col]=='Q') return false;
        }

        //left diagonal check
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }

        //right diagonal check
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
return true;
    }
}
