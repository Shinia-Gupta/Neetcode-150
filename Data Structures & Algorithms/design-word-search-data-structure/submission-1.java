class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children=new HashMap<>();
        endOfWord=false;
    }
}

class WordDictionary {
TrieNode root;
    public WordDictionary() {
root=new TrieNode();
    }

    public void addWord(String word) {
TrieNode curr=root;
for(char c:word.toCharArray()){
    if(!curr.children.containsKey(c)){
        curr.children.put(c,new TrieNode());
    }
    curr=curr.children.get(c);
}
curr.endOfWord=true;
    }

    public boolean search(String word) {

    //hume ek ek root ke bache mei jaake search krna pdega...mtlb recursion lagani pdegi har bche pe
return dfs(word,0,root);
    }

    private boolean dfs(String word,int index,TrieNode curr){
        if(index==word.length()) return curr.endOfWord;

        char c=word.charAt(index);

        if(c=='.'){
            for(TrieNode child:curr.children.values()){
                if(dfs(word,index+1,child)){
                    return true;
                }
            }
            return false;
        }else{
            if(!curr.children.containsKey(c)){
                return false;
            }
            return dfs(word,index+1,curr.children.get(c));
        }
    }

}
