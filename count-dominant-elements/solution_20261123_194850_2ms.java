class Solution {
    public int countDominantElements(int[] nums) {
        int c = 0;
        if(nums.length==1){
            return 1;
        }
        for(int i = 0;i<nums.length;i++){
            int avg = 0;
            if(i==0){
                if(nums[0]>=nums[1])
                    c++;
                continue;
            }
            if(i==nums.length-1){
                if(nums[nums.length-1]>=nums[nums.length-2])
                    c++;
                continue;
            }
            avg = nums[i-1] + nums[i+1];
            if(nums[i]*2>=avg)
                c++;
        }
        return c;
    }
}