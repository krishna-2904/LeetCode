class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = nums.length-1;i>-1;i--){
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]%nums[i]==0){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                }
            }
        }
        int m = 1;
        int a = 0;
        for(int i = 0;i<nums.length;i++){
            if(dp[i]>m){
                m = dp[i];
                a = i;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(dp[i]==m && nums[i]%nums[a]==0){
                a = i;
                m--;
                l.add(nums[i]);
            }
        }
        return l;
    }
}