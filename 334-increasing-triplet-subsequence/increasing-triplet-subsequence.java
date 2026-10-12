class Solution {
    public boolean increasingTriplet(int[] nums) {
        int arr[] = new int[3];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<arr[1]){
                arr[1] = nums[i];
            }
            else if(nums[i]>arr[1]){
                if(nums[i]>arr[2])
                    return true;
                else
                    arr[2] = nums[i];
            }
            System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        }
        return false;
    }
}