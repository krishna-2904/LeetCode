class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[nums.length-1] = 0;
        return f(dp,nums,0);
    }
    public int f(int dp[],int nums[],int i){
        if(i>=nums.length)
            return Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE - 1000;
        int j = i + 1;
        while(j < nums.length && j <= nums[i] + i){
            min = Math.min(min,f(dp,nums,j));
            j++;
        }
        return dp[i] = min + 1;
    }
}