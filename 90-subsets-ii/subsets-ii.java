// In first attempt what mistake I did was that I didn't read question properly and also misunderstood the subset as subarray and wrote the full working code which would not have given any error or wrong answer if it was talking about subarray.
// But the question was about subset so I reattempted and rewrote the full code from scratch and got it accepted in first attempt.
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(set,list,l,nums,0);
        return list;
    }
    public void f(Set<List<Integer>> set,List<List<Integer>> list,List<Integer> l,int nums[],int i){
        if(i==nums.length){
            if(!set.contains(l)){
                set.add(new ArrayList<>(l));
                list.add(new ArrayList<>(l));
            }
            return;
        }
        l.add(nums[i]);
        f(set,list,l,nums,i+1);
        l.remove(l.size()-1);
        f(set,list,l,nums,i+1);
        return;
    }
}