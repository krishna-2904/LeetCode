class Solution {
    public int longestArithSeqLength(int[] nums) {
        ArrayList<HashMap<Integer,Integer>> arr = new ArrayList<>();
        int max = 2;
        for(int i = 0;i<nums.length;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = 0;j<i;j++){
                if(arr.get(j).containsKey(nums[i]-nums[j])){
                    map.put(nums[i]-nums[j],arr.get(j).get(nums[i]-nums[j])+1);
                }
                else{
                    map.put(nums[i]-nums[j],2);
                }
                max = Math.max(max,map.get(nums[i]-nums[j]));
            }
            arr.add(map);
        }
        return max;
    }
}