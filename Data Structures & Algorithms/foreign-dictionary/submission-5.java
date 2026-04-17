class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> graph=new HashMap<>();
      Map<Character,Integer> indegreeMap=new HashMap<>();

      //initialize maps
      for(int i=0;i<words.length;i++){
        String word=words[i];
        for(int j=0;j<word.length();j++){
          char c=word.charAt(j);
          graph.computeIfAbsent(c,x->new ArrayList<>());
          indegreeMap.put(c,0);
        }
      }

      //create directed graph and indegree dependencies
      for(int i=0;i<words.length-1;i++){
        String word1=words[i];
        String word2=words[i+1];
        if(word1.startsWith(word2) && word1.length()>word2.length()){
          return "";
        }

        int minLen=Math.min(word1.length(),word2.length());
        for(int j=0;j<minLen;j++){
          if(word1.charAt(j)!=word2.charAt(j)){
            if(!graph.get(word1.charAt(j)).contains(word2.charAt(j))){
              graph.get(word1.charAt(j)).add(word2.charAt(j));
              indegreeMap.put(word2.charAt(j),indegreeMap.get(word2.charAt(j))+1);
            }
            break;
          }
        }
      }

      Queue<Character> q=new LinkedList<>();
      for(Map.Entry<Character,Integer> entry:indegreeMap.entrySet()){
        if(entry.getValue()==0) q.add(entry.getKey());
      }

      StringBuilder str=new StringBuilder();

      while(!q.isEmpty()){
        char c=q.poll();
        str.append(c);
        for(char neighbor:graph.get(c)){
              indegreeMap.put(neighbor,indegreeMap.get(neighbor)-1);
              if(indegreeMap.get(neighbor)==0) q.add(neighbor);
        }
      }
      return str.length()==indegreeMap.size()?str.toString():"";
    }
}
