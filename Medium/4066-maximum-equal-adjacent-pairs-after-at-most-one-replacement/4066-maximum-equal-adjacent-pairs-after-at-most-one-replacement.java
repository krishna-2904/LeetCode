class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int c = 0;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                c++;
                continue;
            }

            int a = nums[i-1];
            int b = nums[i];
            map.putIfAbsent(a,new HashMap<>());
            map.putIfAbsent(b,new HashMap<>());

            map.get(a).put(b, map.get(a).getOrDefault(b,0)+1);
            map.get(b).put(a, map.get(b).getOrDefault(a,0)+1);
        }
        int max = c;
        for(int x:map.keySet()){
            for(int y:map.get(x).keySet()){
                max = Math.max(max, c + map.get(x).get(y));
            }
        }
        return max;
    }
}