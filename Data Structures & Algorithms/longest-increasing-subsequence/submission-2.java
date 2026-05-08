class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);

        }
       return rec(0,-1,nums,dp);
    }

    private int rec(int curr,int prev,int[] nums,int[][] dp){
        if(curr==nums.length){
            return 0;
        }
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        int takeCurrNum=0,skipCurrNum=0;
        //  skipCurrNum=rec(curr+1,prev,nums); //phle maine skip ko if condition k baad rakh dia tha. toh lekin agar if condition true ho jati h, toh next time after the take condition is fulfilled and returned, skip condition pe take condition ka hi prev value jaa rhi thi. Isliye phle skip call krwadi aur fir take 
        if(prev==-1||nums[curr]>nums[prev]){
            
         takeCurrNum=1+rec(curr+1,curr,nums,dp); //ye toh uss case mei bhi increment krdega length jab curr number is less than prev selected number...toh ye rec call toh hume prev=-1 ya curr num > prev num pe bhejna pdega
        }
        skipCurrNum=rec(curr+1,prev,nums,dp); //phle maine skip ko if condition k baad rakh dia tha. toh lekin agar if condition true ho jati h, toh next time after the take condition is fulfilled and returned, skip condition pe take condition ka hi prev value jaa rhi thi. Isliye phle skip call krwadi aur fir take. othwise prev ko curr hi pass krdia h 

        return dp[curr][prev+1]= Math.max(takeCurrNum,skipCurrNum);
    }

    /*
    hmare pass 2 options h- ya toh hum current number leke lis nikal le ya hum current number skip krke lis nikale
    
    dekh, mera logic kya bn rha h ismei... 
    being on an index, for ex- 0th index, i have 2 options whether to take that number for lis or to skip it. But for taking that number also, i need to check if the prev selected number is less than the curr number being considered. If it is, i can safely mark prev as curr and increase the length so far. 
    otherwise, move to the next index without incrementing the lenght so far
     
    */
}
