// At every index we have already stored the elements before that index in hashmap and check if the exact difference occurs or not and updating accordingly.
class Solution {
    public int longestSubsequence(int[] nums, int difference){
        int arr[] = new int[nums.length];
        Arrays.fill(arr,1);
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i]-difference)){
                int t = map.get(nums[i]-difference);
                map.put(nums[i],t+1);
                arr[i] = t+1;
            }
            else{
                map.put(nums[i],1);
                arr[i] = 1;
            }
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}