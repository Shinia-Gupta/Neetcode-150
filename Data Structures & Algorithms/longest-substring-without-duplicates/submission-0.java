class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> uniqueChars=new HashSet<>();
        int j=0,maxSubstrLen=0;
for(int i=0;i<s.length();i++){
if(uniqueChars.contains(s.charAt(i))){
    while(uniqueChars.contains(s.charAt(i))){
        uniqueChars.remove(s.charAt(j));
        j++;
        
    }
}
uniqueChars.add(s.charAt(i));

maxSubstrLen=Math.max(i-j+1,maxSubstrLen);
}
return maxSubstrLen;
    }
}
