class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    int d = 0;
                    if(i>0 && j>0)
                        d = dp[i-1][j-1];
                    dp[i][j] = d+1;
                }
                else{
                    int top = 0;
                    int left = 0;
                    if(i!=0){
                        top = dp[i-1][j];
                    }
                    if(j!=0)
                        left = dp[i][j-1];
                    dp[i][j] = Math.max(left,top);
                }
            }
        }
        return dp[m-1][n-1];
    }
}