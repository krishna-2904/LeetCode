class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int r[] = new int[nums.length-k+1];
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i = 1;i<k;i++){
            if(nums[i] >= nums[arr.get(0)]){
                arr = new ArrayList<>();
                arr.add(i);
            }
            else{
                int j = arr.size() - 1;
                while(nums[arr.get(j)] <= nums[i]){
                    arr.remove(j);
                    j--;
                }
                arr.add(i);
            }
        }
        int q = 1;
        r[0] = nums[arr.get(0)];
        for(int i = k;i<nums.length;i++){
            if(nums[i] >= nums[arr.get(0)]){
                arr = new ArrayList<>();
                arr.add(i);
            }
            else if(arr.get(0) <= i-k){
                arr.remove(0);
                int j = arr.size() - 1;
                while(j>-1 && nums[arr.get(j)] <= nums[i]){
                    arr.remove(j);
                    j--;
                }
                arr.add(i);
            }
            else{
                int j = arr.size() - 1;
                while(nums[arr.get(j)]<=nums[i]){
                    arr.remove(j);
                    j--;
                }
                arr.add(i);
            }
            r[q++] = nums[arr.get(0)];
        }
        return r;
    }
}