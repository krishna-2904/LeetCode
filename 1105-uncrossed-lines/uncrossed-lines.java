class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int c = 0;
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1;i<dp.length;i++)
        {
            for(int j = 1;j<dp[0].length;j++)
            {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int i = n;
        int j = m;
        while(i>0 && j>0){
            if(nums1[i-1] == nums2[j-1]){
                i--;
                j--;
                c++;
            }
            else if(dp[i][j] == dp[i][j-1]){
                j--;
            }
            else{
                i--;
            }
        }
        return c;
    }
}