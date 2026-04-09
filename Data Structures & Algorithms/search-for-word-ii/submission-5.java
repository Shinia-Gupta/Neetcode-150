public class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfWord;
    String word;
    public TrieNode(){
        children=new HashMap();
        endOfWord=false;
        word=null;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
List<String> res= new ArrayList<String>();
        TrieNode root=new TrieNode();
      //1. create a trie of all the words
        makeWordTree(words,root);
      //2. next, start creating a prefix from the board characters
      // match the prefix with the trie - if it exists, keep on adding more characters from the board
      //otherwise, backtrack from that particular position and find through other directions of the board
      //if for any check in the trie, end of word is true, add it to the set
for(int i=0;i<board.length;i++){
    for(int j=0;j<board[0].length;j++){
        if(root.children.containsKey(board[i][j])){
            dfs(board,i,j,root,res);
    }
        }
    }
    
return res;
}
    }

    private void makeWordTree(String[] words,TrieNode root){
        for(int i=0;i<words.length;i++){
            String word=words[i];
            TrieNode curr=root;
            for(char c:word.toCharArray()){
                if(curr.children.containsKey(c)){
                    curr=curr.children.get(c);
                }else{
                    TrieNode newNode=new TrieNode();
                    curr.children.put(c,newNode);
                    curr=curr.children.get(c);

                }
            }
            curr.endOfWord=true;
            curr.word=word;
        }
    }

private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {

    // boundary
    if(row<0 || col<0 || row>=board.length || col>=board[0].length)
        return;

    char ch = board[row][col];

    if(ch == '#' || !node.children.containsKey(ch))
        return;

    node = node.children.get(ch);

    if(node.endOfWord){
        result.add(node.word);   // <-- store word inside trie node
        node.endOfWord = false;  // avoid duplicates
    }

    board[row][col] = '#';

    dfs(board,row+1,col,node,result);
    dfs(board,row-1,col,node,result);
    dfs(board,row,col+1,node,result);
    dfs(board,row,col-1,node,result);

    board[row][col] = ch;
}


