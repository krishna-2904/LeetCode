class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return f(dp,n);
    }
    public int f(int dp[],int n){
        if(n==0) 
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int min = 10000000;
        for(int i = 1;i*i<=n;i++){
            min = Math.min(min,1 + f(dp,n-(i*i)));
        }
        return dp[n] = min;
    }
}