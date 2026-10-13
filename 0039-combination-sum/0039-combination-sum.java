// My approach to this question is simply using for loop for the rest of the elements and also include that index untill target becomes smaller than that element.

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(list,l,candidates,target,0);
        return list;
    }
    public void f(List<List<Integer>> list, List<Integer> l, int arr[],int t,int i){
        if(t==0){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int k = i;k<arr.length;k++){
            if(arr[k]>t)
                break;
            l.add(arr[k]);
            f(list,l,arr,t-arr[k],k);
            l.remove(l.size()-1);
        }
        return;
    }
}