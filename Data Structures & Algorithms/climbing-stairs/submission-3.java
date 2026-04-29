class Solution {
    public int climbStairs(int n) {
        int[] tab=new int[n+1];
        tab[n]=1;
        for(int i=n-1;i>=0;i--){
            tab[i]=tab[i+1]+(i+2<=n?tab[i+2]:0);

        }
        return tab[0];
    }
}
