class Solution {
    public boolean predictTheWinner(int[] nums) {
        if(f(nums,0,nums.length-1,0)>=0)
            return true;
        return false;
    }
    public int f(int nums[],int a,int b,int t){
        if(a>b){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(t==0){
            left = nums[a] + f(nums,a+1,b,1);
            right = nums[b] + f(nums,a,b-1,1);
            return Math.max(left,right);
        }
        else{
            left = f(nums,a+1,b,0) - nums[a];
            right = f(nums,a,b-1,0) - nums[b];
            return Math.min(left,right);
        }
    }
}