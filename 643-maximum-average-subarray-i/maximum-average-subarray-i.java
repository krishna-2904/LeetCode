// First find the sum of first subarray.
// Then in loop add next and remove first element of new subarray and compare with max.
// return max average.
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += nums[i];
        }
        max = sum;
        for(int i = k;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(max,sum);
        }
        return (double)max/k;
    }
}