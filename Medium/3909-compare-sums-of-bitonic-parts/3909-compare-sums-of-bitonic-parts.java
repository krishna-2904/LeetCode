class Solution {
    public int compareBitonicSums(int[] nums) {
        int max = nums[0];
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        long s1 = 0;
        long s2 = 0;
        for(int i = 0;i<=index;i++){
            s1 += nums[i];
        }
        for(int i = index;i<nums.length;i++){
            s2 += nums[i];
        }
        if(s1>s2)
            return 0;
        if(s2>s1)
            return 1;
        return -1;
    }
}