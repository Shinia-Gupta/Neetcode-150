class Solution {
    //space optimized solution - without using an additional visited matrix
    public boolean exist(char[][] board, String word) {
        // boolean visited[][]=new boolean[board.length][board[0].length];
        int index=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
if(board[i][j]==word.charAt(index)){
if(track(board,i,j,word,index)) return true;
}
            }
        }
        return false;
    }

    private boolean track(char[][] board,int i,int j,String word,int index ){
if(index>=word.length()){
    return true;
}
if(i<0||i>=board.length||j<0||j>=board[0].length|| board[i][j]=='#'){
    return false;
}
char temp=board[i][j];
if(board[i][j]!=word.charAt(index)){
    return false;
}else{
    board[i][j]='#';
}

boolean found= track(board,i,j+1,word,index+1) || track(board,i+1,j,word,index+1) || track(board,i-1,j,word,index+1) || track(board,i,j-1,word,index+1);
   board[i][j]=temp;
   return found;
    }
}
