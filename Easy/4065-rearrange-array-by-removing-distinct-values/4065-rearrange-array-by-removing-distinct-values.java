class Solution {
    public int[] rearrangeArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int arr[] = new int[nums.length];
        int c = nums.length;
        int q = 0;
        while(c>0){
            map = new HashMap<>();
            for(int i = 0;i<nums.length;i++){
                if(nums[i]!=-1){
                    if(map.containsKey(nums[i])){
                        map.put(nums[i],map.get(nums[i])+1);
                    }
                    else{
                        map.put(nums[i],1);
                        nums[i] = -1;
                        c--;
                    }
                }
            }
            int temp[] = new int[map.size()];
            int k = 0;
            for(int n:map.keySet()){
                temp[k++] = n;
            }
            Arrays.sort(temp);
            k = 0;
            for(;k<temp.length;k++){
                arr[q++] = temp[k];
            }
        }
        return arr;
    }
}