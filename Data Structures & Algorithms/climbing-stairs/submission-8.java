class Solution {
    public int climbStairs(int n) {
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return memoized(n,memo);

    }

    private int memoized(int n,int memo[]){

        if(n<=1) return 1;
        if(memo[n]!=-1) return memo[n];
        return memo[n]=memoized(n-1,memo)+memoized(n-2,memo);
    }
}
