class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> result=new ArrayList<>();
       HashMap<String,List<String>> wordToAnagramMap=new HashMap<>();
       
       for(int i=0;i<strs.length;i++){
        String word=strs[i];
        char[] charArr=word.toCharArray();
        Arrays.sort(charArr);
        String sortedWord=new String(charArr);
        if(wordToAnagramMap.containsKey(sortedWord)){
            List<String> existingList=wordToAnagramMap.get(sortedWord);
            existingList.add(word);
            wordToAnagramMap.put(sortedWord,existingList);

        }else{
            List<String> newList=new ArrayList<>();
            newList.add(word);
            wordToAnagramMap.put(sortedWord,newList);
        }
       }
       for(Map.Entry<String,List<String>> entry:wordToAnagramMap.entrySet()){
        result.add(entry.getValue());
       }
       return result;
    }
}
