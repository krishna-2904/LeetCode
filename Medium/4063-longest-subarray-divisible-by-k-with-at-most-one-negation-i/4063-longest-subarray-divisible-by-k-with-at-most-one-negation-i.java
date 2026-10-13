class Solution {
    public int longestSubarray(int[] nums, int k) {
        int p[] = new int[nums.length + 1];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            p[i+1] = p[i] + nums[i];
            sum += nums[i];
        }
        int max = 0;
        for(int a = 0;a<nums.length;a++){
            HashSet<Integer> set = new HashSet<>();
            for(int l = 1;l<nums.length-a+1;l++){
                set.add(((2*nums[a+l-1])%k + k)%k);
                sum = p[a+l] - p[a];
                int req = ((sum%k) + k)%k;                
                if(set.contains(req) || sum%k==0 )
                    max = Math.max(max,l);
            }
        }
        return max;
    }
    public boolean f(int arr[],int nums[], int i,int j,int k,HashSet<Integer> set){
        int sum = arr[j] - arr[i];
        if(sum%k==0) 
            return true;
        for(;i<j;i++){
            if((sum - nums[i] - nums[i] )%k == 0)
                return true;
        }
        return false;
    }
}