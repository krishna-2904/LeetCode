// In this question my approach was that start from last and find the number after which it will be upgraded like everytime element upgraded to its next maximum or if it is maximum then to the smallest accordingly.

// After finding the number replace the number with the next maximum and reset the right part of array which means sort it in ascending order.
// If array is fully at max then next lexicographically array we will return will be the smallest one as this is the cycle. So simply sort the array.
class Solution {
    public void nextPermutation(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        for(int i = nums.length-1;i>=0;i--){
            int max = f1(nums,i);
            if(max == nums[i]){
                continue;
            }
            else{
                int m = Integer.MAX_VALUE;
                int ind = -1;
                for(int j = i+1;j<nums.length;j++){
                    if(nums[j] > nums[i] && nums[j] < m){
                        m = nums[j];
                        ind = j;
                    }
                }
                int temp = nums[i];
                nums[i] = m;
                nums[ind] = temp;
                for(int k = 0;k<nums.length;k++){
                }
                for(int j = i + 1;j<nums.length;j++){
                    for(int k = i + 1;k<nums.length;k++){
                        if(nums[k]>nums[j]){
                            int t = nums[k];
                            nums[k] = nums[j];
                            nums[j] = t;
                        }
                    }
                }
                return;
            }
        }
        Arrays.sort(nums);
    }
    public int f1(int nums[],int i){
        int max = nums[i];
        for(int j = i+1;j<nums.length;j++)
            max = Math.max(max,nums[j]);
        return max;
    }
}