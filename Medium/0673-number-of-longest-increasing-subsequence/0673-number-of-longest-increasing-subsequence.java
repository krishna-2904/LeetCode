class Solution {
    public int findNumberOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        Arrays.fill(arr,1);
        int m = 0;
        for(int i = nums.length-1;i>=0;i--){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]<nums[j])
                    arr[i] = Math.max(arr[i],arr[j]+1);
            }
            m = Math.max(m,arr[i]);
        }
        int dp[] = new int[arr.length];
        Arrays.fill(dp,1);
        for(int i = nums.length-1;i>=0;i--){
            int sum = 0;
            for(int j = i+1;j<nums.length;j++){
                if(arr[j]==arr[i]-1 && nums[j]>nums[i]){
                    sum += dp[j];
                }
            }
            if(sum>0)
                dp[i] = sum;
        }
        int s = 0;
        for(int i = 0;i<nums.length;i++){
            if(arr[i]==m)
                s += dp[i];
        }
        return s;
    }
}