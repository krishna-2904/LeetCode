class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int inc[] = new int[nums.length];
        int dec[] = new int[nums.length];
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    inc[i] = Math.max(inc[i],inc[j]+1);
                }
            }
        }
        for(int i = nums.length-2;i>=0;i--){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    dec[i] = Math.max(dec[i],dec[j]+1);
                }
            }
        }
        int m = 0;
        for(int i = 0;i<nums.length;i++){
            if(inc[i]!=1 && dec[i]!=1)
                m = Math.max(m,inc[i]+dec[i]-1);
        }
        return nums.length-m;
    }
}