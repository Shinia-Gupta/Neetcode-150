class Solution {
      Map<Character,List<Character>> graph=new HashMap<>();
      int[] state=new int[26];  //by default each index value is initialized to 0
      StringBuilder result=new StringBuilder();

    public String foreignDictionary(String[] words) {
      //DFS TOPO APPRAOCH
      //yaha hume prefix length of 2 words check krne ki zarurat hi ni padi...


      
      for(int i=0;i<words.length;i++){
        String word=words[i];

        for(char c:word.toCharArray()){
          graph.computeIfAbsent(c,x->new ArrayList<>());
        }
      }

      //directed edges
      for(int i=0;i<words.length-1;i++){
        String word1=words[i],word2=words[i+1];

        if(word1.startsWith(word2) && word1.length()>word2.length()) return "";
        
        int minLen=Math.min(word1.length(),word2.length());

        for(int j=0;j<minLen;j++){
          if(word1.charAt(j)!=word2.charAt(j)){
            if(!graph.get(word1.charAt(j)).contains(word2.charAt(j))){
              graph.get(word1.charAt(j)).add(word2.charAt(j));
            }
            break;
          }
        }
      }

      for(char c:graph.keySet()){
        if(state[c-'a']==0){
          if(!dfs(c)) return "";
        }
      }

      return result.reverse().toString();


    }

    private boolean dfs(char c){
      if(state[c-'a']==1) return false; //detected cycle
      if(state[c-'a']==2) return true;
      
      state[c-'a']=1; //currently visiting in that dfs cycle

      for(char neighbor:graph.get(c)){
        if(!dfs(neighbor)) return false;
      }

      state[c-'a']=2;
      result.append(c);
      return true;
    }
}
