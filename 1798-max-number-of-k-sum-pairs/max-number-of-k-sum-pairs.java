class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int c = 0;
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.containsKey(k-nums[i])){
                    if(nums[i]==k-nums[i]){
                        if(map.get(nums[i])==2){
                            map.remove(nums[i]);
                            c++;
                        }
                        else if(map.get(nums[i])>2){
                            map.put(nums[i],map.get(nums[i])-2);
                            c++;
                        }
                    }
                    else{
                        if(map.get(nums[i])==1){
                            map.remove(nums[i]);
                        }
                        else{
                            map.put(nums[i],map.get(nums[i])-1);
                        }
                        if(map.get(k-nums[i])==1){
                            map.remove(k-nums[i]);
                        }
                        else{
                            map.put(k-nums[i],map.get(k-nums[i])-1);
                        }
                        c++;
                    }
                }
            }
        }
        return c;
    }
}