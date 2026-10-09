// Accepted in first attempt without any logical error
// Created three lists
// First which is 2d list which stores whatever the answer is calculated and this list will be returned by the function.
// Second list is for the current elements we have taken or the path of elements we are on which will later on be stored in list.
// Third list contains elements which are still remaining to be traversed and also created a temp array for easy logic.
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