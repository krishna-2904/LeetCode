class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0;i<nums.length-3;i++){
            for(int j = i+1;j<nums.length-2;j++){
                int l = j + 1;
                int h = nums.length-1;
                long sum = nums[i] + nums[j];
                long r = target - sum ; 
                while(l<h){
                    if(r == nums[l] + nums[h]){
                        list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[h]);
                        if(!set.contains(list))
                            re.add(list);
                        set.add(list);
                        h--;
                    }
                    else if(r > nums[l] + nums[h]){
                        l++;
                    }
                    else
                        h--;
                }
            }
        }
        return re;
    }
}