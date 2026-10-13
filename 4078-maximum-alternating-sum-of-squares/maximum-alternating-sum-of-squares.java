class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        nums = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        int n = nums.length;
        n = n / 2;
        long s1 = 0;
        long s2 = 0;
        for(int i = 0;i<n;i++){
            s1 = s1 + (nums[i]*nums[i]);
        }
        for(int i = n;i<nums.length;i++){
            s2 = s2 + (nums[i]*nums[i]);
        }
        return s2-s1;
    }
}