// My approach to this question is that as we have to return true as we find and LIS of length 3 no need to further calculate.
// So I created a array of size 3 in which arr[1] will be the first number of nums and loop will start from 1 index.

// We store minimum number at 1 and 2 who get those length so any next number greator than them will definetly increase the length of subsequence.

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int arr[] = new int[3];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<arr[1]){
                arr[1] = nums[i];
            }
            else if(nums[i]>arr[1]){
                if(nums[i]>arr[2])
                    return true;
                else
                    arr[2] = nums[i];
            }
        }
        return false;
    }
}