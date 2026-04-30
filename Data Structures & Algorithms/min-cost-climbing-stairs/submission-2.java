class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int[] memo=new int[cost.length];
      Arrays.fill(memo,-1);
        return Math.min(recursion(cost,0,memo),recursion(cost,1,memo));
    }

    private int recursion(int[] cost,int currStep,int[] memo){
      if(currStep>=cost.length) return 0;

      if(memo[currStep]!=-1) return memo[currStep];
        int currRes= cost[currStep]+Math.min(recursion(cost,currStep+1,memo),recursion(cost,currStep+2,memo));
        memo[currStep]=currRes;
        return memo[currStep];
    }
}
