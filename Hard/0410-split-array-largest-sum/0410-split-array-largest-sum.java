class Solution {
    public int splitArray(int[] nums, int k) {
        int dp[][] = new int[nums.length][k+1];
        for(int i = 0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return f(nums,dp,0,k);
    }
    public int f(int nums[],int dp[][],int a,int k){
        if(dp[a][k]!=-1)
            return dp[a][k];
        if(k==1){
            int sum = 0;
            for(int i = a;i<nums.length;i++)
                sum += nums[i];
            return dp[a][k] = sum;
        }
        int max = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = a;i<nums.length-k+1;i++){
            sum = sum + nums[i];
            max = Math.max(sum,f(nums,dp,i+1,k-1));
            min = Math.min(min,max);
        }
        return dp[a][k] = min;
    }
}