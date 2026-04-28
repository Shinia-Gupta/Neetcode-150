class Solution {
    public int climbStairs(int n) {
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
       return climbStairsRec(n,0,memo);
    }

    private int climbStairsRec(int dest,int curr,int memo[]){
        if(curr==dest){
            return 1;
        }
        if(curr>dest) return 0;
        if(memo[curr]!=-1) return memo[curr];
        int res= climbStairsRec(dest,curr+1,memo)+climbStairsRec(dest,curr+2,memo);
        memo[curr]=res;
        return res;
    }
}
