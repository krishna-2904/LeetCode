class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return f(dp,arr,0,k);
    }
    public int f(int dp[],int arr[],int i,int k){
        if(i==arr.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int max = Integer.MIN_VALUE;
        int curr_max = arr[i];
        for(int j = i;j<arr.length && j<i+k;j++){
            curr_max = Math.max(curr_max,arr[j]);
            int curr = curr_max * (j-i+1);
            int right = f(dp,arr,j+1,k);
            max = Math.max(max,curr+right);
        }
        return dp[i] = max;
    }
}