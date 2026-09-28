class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(list,l,nums,0);
        return list;
    }
    public void f(List<List<Integer>> list,List<Integer> l,int nums[],int i){
        if(i==nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        f(list,l,nums,i+1);
        l.add(nums[i]);
        f(list,l,nums,i+1);
        l.remove(Integer.valueOf(nums[i]));
        return;
    }
}