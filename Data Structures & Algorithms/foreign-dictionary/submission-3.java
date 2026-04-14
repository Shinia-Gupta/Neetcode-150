class Solution {
    public String foreignDictionary(String[] words) {
 // topological sort ka question hai
 // hum 2 consecutive words ko comapre krenge
 // jaise hi unn words ke letters mei difference aayega, hum uske letters mei directed edge bna denge to signify the order of differing letters
 //aise krte krte hum sab words ka directional dependency bna lenge. ab har letter ki single directional dependency hi aayegi, usse zada nhi aa sakti
 //fir hum uss adjacency list ko traverse krenge dfs form mei. uss adjacency list ko traverse krke hum ek word bna lenge and that will be our answer
 Map<Character,List<Character>> graph=new HashMap<>();
 Map<Character, Integer> indegree=new HashMap<>();

 for(String word:words){
    for(char c:word.toCharArray()){
        graph.computeIfAbsent(c,x->new ArrayList<>());
        indegree.putIfAbsent(c,0);
    }
 }

 for(int i=0;i<words.length-1;i++){
    String word1=words[i];
    String word2=words[i+1];
    
    //check invalid case - if word1 is a prefix of word2 and if prefix length is greater than the actual word 
    if(word1.startsWith(word2) && word1.length()>word2.length()){
        return "";
    }

    //MISTAKE
    // for(char c1:word1.toCharArray()){
    //     for(char c2:word2.toCharArray()){
    //         if(c1!=c2){
    //             graph.get(c1).add(c2);
    //             int indegCount=indegree.getOrDefault(c2,0)+1;
    //             indegree.put(c2,indegCount);
    //         }
    //     }
    // }

    int len=Math.min(word1.length(),word2.length());

    for(int j=0;j<len;j++){
        char c1=word1.charAt(j);
        char c2=word2.charAt(j);

        if(c1!=c2){
            if(!graph.get(c1).contains(c2)){
                graph.get(c1).add(c2);
                // int indegCount=indegree.getOrDefault(c2,0)+1;
                indegree.put(c2,indegree.get(c2)+1);  
            }    
                break;      
        }
    }

 }

 Queue<Character> queue=new LinkedList<>();
 StringBuilder res=new StringBuilder();

 //initialize queue
 for(Map.Entry<Character,Integer> entry:indegree.entrySet()){
    if(entry.getValue()==0) queue.add(entry.getKey());
 }

 while(!queue.isEmpty()){
    char node=queue.poll();
    res.append(node);
    for(char neighbor:graph.get(node)){
        indegree.put(neighbor,indegree.get(neighbor)-1);
        if(indegree.get(neighbor)==0) queue.add(neighbor);

    }
 }
 return res.length()==graph.size()?res.toString():"";
    }
}
