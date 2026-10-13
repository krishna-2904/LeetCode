class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++)
            if(f(nums[i])==i)
                return i;
        return -1;
    }
    public int f(int n){
        if(n==0)
            return 0;
        return n%10 + f(n/10);
    }
}