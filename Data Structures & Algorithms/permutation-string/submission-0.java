class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq=new int[26];
        int[] s2Freq=new int[26];
        if(s2.length()<s1.length()) return false;
// Arrays.fill
        for(int i=0;i<s1.length();i++){
            s1Freq[s1.charAt(i)-'a']++;
        }
        int windowSize=s1.length();
        for(int i=0;i<windowSize;i++){
            s2Freq[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1Freq,s2Freq)) return true;

        //start sliding window
        for(int i=windowSize;i<s2.length();i++){
            s2Freq[s2.charAt(i-windowSize)-'a']--;
            s2Freq[s2.charAt(i)-'a']++;
        if(Arrays.equals(s1Freq,s2Freq)) return true;

        }

return false;
    }
}
