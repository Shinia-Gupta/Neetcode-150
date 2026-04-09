class TrieNode{
    // Space optimized approach
    // TrieNode[] children=new TrieNode[26];
    Map<Character,TrieNode> children;
    boolean endOfWord;
    public TrieNode(){
         children=new HashMap<>();
         endOfWord=false;
    }
}
class PrefixTree {
private TrieNode root;
    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
//when we need to insert, we need to check if the character with that word exists. 
//if it exists, we need to traverse further for next character of the word in the same tail 
//if it does not exist, we need to add that character as a new entry
//for each character we add, we need to maintain a list of characters that come after that particular character.Each character will definitely include its own list of characters
   TrieNode curr=root;
   for(char c:word.toCharArray()){
// int i=c-'a';
if(!curr.children.containsKey(c)){
    curr.children.put(c,new TrieNode());
}
curr=curr.children.get(c);
   }
   curr.endOfWord=true;
    }

    public boolean search(String word) {
//if we find the first character of the given word, we need to traverse further in its character list for the next character of the word. if the word length ends and there is a limiter added after each word added and that has been reached, we need to return true, otherwise false
TrieNode curr=root;
for(char c:word.toCharArray()){
    // int i=c-'a';
    if(!curr.children.containsKey(c)){
        return false;
    }
curr=curr.children.get(c);
}
return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
//if we find the first character of the given refix,we traverse further in the set of characters for that character. 
//As soon as we find the character and prefix length is reached, we return true. else we search in other lists of the character. if found nothing, we return false. 
   TrieNode curr=root;
   for(char c:prefix.toCharArray()){
    // int i=c-'a';
    if(!curr.children.containsKey(c)){
        return false;
    }
curr=curr.children.get(c);
   }
   return true;
    }
}

