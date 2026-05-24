class Solution {
    public int climbStairs(int n) {
        int[] memoi=new int[n+1];
        Arrays.fill(memoi,-1);
        return recMemo(n,memoi);

    }

    private int recMemo(int n,int[] memoi){
        if(n<=1) return 1;
        if(memoi[n]!=-1) return memoi[n];
       return memoi[n]=recMemo(n-1,memoi)+recMemo(n-2,memoi);
    }
}
