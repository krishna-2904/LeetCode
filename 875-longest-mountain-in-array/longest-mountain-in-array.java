class Solution {
    public int longestMountain(int[] nums) {
        int inc[] = new int[nums.length];
        int dec[] = new int[nums.length];
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                inc[i] = inc[i-1]+1;
            }
        }
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                dec[i]  = dec[i+1]+1;
            }
        }
        int m = 0;
        for(int i = 0;i<nums.length;i++){
            System.out.println(inc[i]+" "+dec[i]);
            if(inc[i]!=1 && dec[i]!=1){
                m = Math.max(m,inc[i]+dec[i]-1);
            }
        }
        return m;
    }
}