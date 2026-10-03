class Solution {
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length];
        Arrays.fill(dp,-1);
        return f(dp,questions,0);
    }
    public long f(long dp[],int q[][],int i){
        if(i>=dp.length)
            return 0;
        if(dp[i]!=-1)   
            return dp[i];
        dp[i] = Math.max(f(dp,q,i+1) , q[i][0] + f(dp,q,i+q[i][1]+1));
        return dp[i];
    }
}