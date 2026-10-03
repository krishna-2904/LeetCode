class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int dp[][] = new int[nums.length][target+1];
        for(int i = 0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return f(dp,nums,target,0);
    }
    public int f(int dp[][],int nums[],int t,int i){
        if(t==0)
            return 1;
        if(dp[i][t]!=-1)
            return dp[i][t];
        int c = 0;
        int j = 0;
        while(j<nums.length && nums[j]<=t){
            c += f(dp,nums,t-nums[j],j);
            j++;
        }
        return dp[i][t] = c;
    }
}