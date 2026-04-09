class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][]=new boolean[board.length][board[0].length];
        int index=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
if(board[i][j]==word.charAt(index)){
if(track(board,i,j,visited,word,index)) return true;
}
            }
        }
        return false;
    }

    private boolean track(char[][] board,int i,int j,boolean visited[][],String word,int index ){
if(index>=word.length()){
    return true;
}
if(i<0||i>=board.length||j<0||j>=board[0].length|| visited[i][j]){
    return false;
}
if(board[i][j]!=word.charAt(index)){
    return false;
}else{
    visited[i][j]=true;
}

boolean found= track(board,i,j+1,visited,word,index+1) || track(board,i+1,j,visited,word,index+1) || track(board,i-1,j,visited,word,index+1) || track(board,i,j-1,visited,word,index+1);
   visited[i][j]=false;
   return found;
    }
}
