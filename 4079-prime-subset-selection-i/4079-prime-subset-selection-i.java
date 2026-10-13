class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean arr[] = new boolean[n+1];
        Arrays.fill(arr,true);
        arr[1] = false;
        for(int i = 2;i*i<=n;i++){
            if(arr[i]){
                for(int j = i*i;j<=n;j+=i){
                    arr[j] = false;
                }
            }
        }
        int c = 0;
        for(int i = 1;i<=n;i++)
            if(arr[i] == true)
                c++;
        int nums[] = new int[c];
        c = 0;
        for(int i = 1;i<=n;i++)
            if(arr[i]==true)
                nums[c++] = i;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(sum+nums[i]>s){
                return list;
            }
            sum = sum + nums[i];
            list.add(nums[i]);
        }
        return list;
    }
}