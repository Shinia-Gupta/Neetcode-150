class Solution {
    public int climbStairs(int n) {
        // space optimization 
        int nextStep1=1,nextStep2=0;
        for(int i=n-1;i>=0;i--){
            int curr=nextStep1+nextStep2;
            nextStep2=nextStep1;
            nextStep1=curr;
        }

        return nextStep1;
    }
}
