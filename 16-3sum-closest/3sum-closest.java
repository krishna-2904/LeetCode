// My approach to this question is that firstly I will sort the array
// Use two pointers first on first element second on last element.
// now binary search for remaining target.
// 
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3){
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                int sum = nums[i] + nums[j];
                int r = target - sum;
                if(r<=nums[j+1]){
                    sum = sum + nums[j+1];
                    if(Math.abs(sum - target)<Math.abs(result-target))
                        result = sum;
                }
                else if(r>=nums[nums.length-1]){
                    sum = sum + nums[nums.length-1];
                    if(Math.abs(sum - target)<Math.abs(result-target))
                        result = sum;
                }
                else{
                int l = j+1;
                int m = l;
                int h = nums.length-1;
                while(l<h){
                    m = (l+h)/2;
                    if(nums[m]==r)
                        return target;
                    if(nums[m]<r)
                        l = m+1;
                    else
                        h = m-1;
                }
                if(Math.abs(nums[m]-r)>Math.abs(nums[m+1]-r)){
                    m = m+1;
                }
                sum = sum + nums[m];
                if(Math.abs(sum - target)<Math.abs(result-target))
                        result = sum;
                }
            }
        }
        return result;
    }
}