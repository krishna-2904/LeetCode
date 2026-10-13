class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            int arr[] = new int[2];
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        int l = 1;
        int h = nums.length-1;
        int m = 0;
        int a = -1;
        if(nums[m]==target)
            a = 0;
        else
            while(l<=h){
                m = (l+h)/2;
                if(nums[m-1]<target && nums[m]==target){
                    a = m;
                    break;
                }
                if(nums[m]<target){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
        if(a==-1){
            int arr[] = new int[2];
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        int b = -1;
        if(nums[nums.length-1]==target){
            b = nums.length-1;
        }
        else{
            l = a;
            h = nums.length-2;
            while(l<=h){
                m = (l+h)/2;
                if(nums[m]==target && nums[m+1]>target){
                    b = m;
                    break;
                }
                if(nums[m]>target){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
        }
        int arr[] = new int[2];
        arr[0] = a;
        arr[1] = b;
        return arr;
    }
}