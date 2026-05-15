class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
            int take=0,skip=0,skipText1=0,skipText2=0;
                if(text1.charAt(i)==text2.charAt(j)){
                    take=1+dp[i+1][j+1];
                }else{
                    skipText1=dp[i+1][j];
                    skipText2=dp[i][j+1];
                    skip=Math.max(skipText1,skipText2);
                }
                dp[i][j]=Math.max(take,skip);
            }
        }
        return dp[0][0];
            }
}
