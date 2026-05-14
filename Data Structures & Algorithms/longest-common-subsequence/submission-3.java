class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo=new int[text1.length()][text2.length()];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return rec(0,0,text1,text2);
    }

    private int rec(int i,int j,String text1,String text2){
        if(i==text1.length()||j==text2.length()){
            return 0;
        }
        if(memo[i][j]!=-1) return memo[i][j];

        int takeLen=0,skipText1=0,skipText2=0,skipLen=0;
        if(text1.charAt(i)==text2.charAt(j)){
            takeLen=1+rec(i+1,j+1,text1,text2);
        }else{
            skipText1=rec(i+1,j,text1,text2);
            skipText2=rec(i,j+1,text1,text2);
            skipLen=Math.max(skipText1,skipText2);
        }

        return memo[i][j]=Math.max(skipLen,takeLen);
    }
}
