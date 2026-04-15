class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> graph=new HashMap<>();
      Map<Character,Integer> indegreeMap=new HashMap<>();

      //initialize graph
      for(String word:words){
        for(char c:word.toCharArray()){
            graph.computeIfAbsent(c,x->new ArrayList<>());
            indegreeMap.putIfAbsent(c,0);
        }
      }

      //create directed edges
      for(int i=0;i<words.length-1;i++){
        String word1=words[i];
        String word2=words[i+1];

        if(word1.startsWith(word2) && word1.length()>word2.length()) return "";

        int minLen=Math.min(word1.length(),word2.length());
        for(int j=0;j<minLen;j++){
            char c1=word1.charAt(j);
            char c2=word2.charAt(j);

            if(c1!=c2){
                if(!graph.get(c1).contains(c2)){
                    graph.get(c1).add(c2);
                    indegreeMap.put(c2,indegreeMap.get(c2)+1);
                }
                break;
            }
        }
      }

      //initialize queue for processing
      Queue<Character> q=new LinkedList<>();
      for(Map.Entry<Character,Integer> entry:indegreeMap.entrySet()){
        if(entry.getValue()==0) q.add(entry.getKey());
      }

      //start processing the nodes
      StringBuilder res=new StringBuilder();
      while(!q.isEmpty()){
        char node=q.poll();
        res.append(node);
        for(char neighbor:graph.get(node)){
            indegreeMap.put(neighbor,indegreeMap.get(neighbor)-1);
            if(indegreeMap.get(neighbor)==0) q.add(neighbor);
        }
      }

      return res.length()==indegreeMap.size()?res.toString():"";
    }
}
