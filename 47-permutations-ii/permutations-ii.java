class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> list = new HashSet<>();
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<nums.length;i++)
            arr.add(nums[i]);
        f(list,l,arr);
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> ll:list)
            result.add(ll);
        return result;
    }
    public void f(Set<List<Integer>> list,ArrayList<Integer> l,ArrayList<Integer> arr){
        if(arr.size()==0){
            list.add(new ArrayList<>(l));
            return;
        }
        int temp[] = new int[arr.size()];
        int i = 0;
        for(int j:arr){
            temp[i++] = j;
        }
        for(i = 0;i<temp.length;i++){
            int t = temp[i];
            arr.remove(i);
            l.add(t);
            f(list,l,arr);
            arr.add(i,t);
            l.remove(l.size()-1);
        }
        return;
    }
}