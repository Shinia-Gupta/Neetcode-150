class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen=0,j=0,maxFreq=0;
        HashMap<Character,Integer> charToCountMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
charToCountMap.put(s.charAt(i),charToCountMap.getOrDefault(s.charAt(i),0)+1);
maxFreq=Math.max(maxFreq,charToCountMap.get(s.charAt(i)));
int numberOfReplacements=(i-j+1)-maxFreq;
    while(numberOfReplacements>k){
    charToCountMap.put(s.charAt(j),charToCountMap.get(s.charAt(j))-1);
j++;
numberOfReplacements=(i-j+1)-maxFreq;
    }
maxLen=Math.max(maxLen,i-j+1);
        }
        return maxLen;
    }
}
