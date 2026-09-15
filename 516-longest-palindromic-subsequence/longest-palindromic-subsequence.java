class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String ss = rev(s);
        int dp[][] = new int[n+1][n+1];
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=n;j++)
            {
                if(s.charAt(i-1)==ss.charAt(j-1)) 
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }
    public String rev(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1;i>-1;i--)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}