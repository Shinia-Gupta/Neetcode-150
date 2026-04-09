class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       //check if the endword exists in word list. if it doesnt exist, directly return 0
       /*
       convert the word list into the set, we are not going to traverse and get the word again as it is now set as visited. So this will avoid infinite loop in case, any pattern matches the word repeatedly in the set
       Create patterns for each word. if that pattern exists in the set, add that pattern to the queue and remove that pattern from the set. Also, increment the sequence size by 1
       
       */ 

       Set<String> wordsSet=new HashSet<>(wordList);
       Queue<String> words=new LinkedList<>();
        words.add(beginWord);
        if(!wordsSet.contains(endWord)) return 0;
        int seqSize=0;
       while(!words.isEmpty()){
            seqSize++;
            for(int i=words.size();i>0;i--){
                String word=words.poll();
                if(word.equals(endWord)) return seqSize;
                for(int j=0;j<word.length();j++){
                    for(char c='a';c<='z';c++){
                        String pattern=word.substring(0,j)+c+word.substring(j+1);
                        if(wordsSet.contains(pattern)){
                            wordsSet.remove(pattern);
                            words.add(pattern);
                        }
                    }
                }
            }
       }
       return 0;
    }
}
