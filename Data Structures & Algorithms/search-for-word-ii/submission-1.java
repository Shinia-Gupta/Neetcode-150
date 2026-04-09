class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set=new HashSet<>();
        backtrack(board,words,set);

        List<String> res=new ArrayList<>(set);
        return res;
    }

    private void backtrack(char[][] board,String[] words,HashSet<String> set){

        for(int w=0;w<words.length;w++){
            String word=words[w];
            int index=0;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,index)){
                        set.add(word);
                    }
                    }
                }
            }
           
        }
    }

    private boolean dfs(char[][] board, String word,int i,int j,int index){
        if(index==word.length()){
            return true;
        }

        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='*'||board[i][j]!=word.charAt(index)){
            return false;
        }

        char temp=word.charAt(index);
        board[i][j]='*';
        //down
        boolean down= dfs(board,word,i+1,j,index+1);
        //right
        boolean right= dfs(board,word,i,j+1,index+1);
        //up
        boolean up=dfs(board,word,i-1,j,index+1);
        //left
        boolean left=dfs(board,word,i,j-1,index+1);
        board[i][j]=temp;
return down||up||left||right;
        
    }
}
