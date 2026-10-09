class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i<nums.length;i++)
            arr.add(nums[i]);
        f(list,l,arr);
        return list;
    }
    public void f(List<List<Integer>> list,List<Integer> l,List<Integer> arr){
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
            arr.remove(Integer.valueOf(t));
            l.add(t);
            f(list,l,arr);
            arr.add(t);
            l.remove(Integer.valueOf(t));
        }
        return;
    }
}