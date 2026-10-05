// My approach to this question is that firstly I will sort the array
// Use two pointers first on first element second on last element.
// now binary search for remaining target.
// 
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                for(int k = j+1;k<nums.length;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(sum-target)<min){
                        min = Math.abs(sum-target);
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}