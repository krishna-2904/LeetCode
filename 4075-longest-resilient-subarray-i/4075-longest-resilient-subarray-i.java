class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int max = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int rem = nums[i] % k;
            boolean fl = true;

            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (nums[j] % k != rem)
                    fl = false;

                if (fl && sum % k == rem)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
        // int sum = 0;
        // int arr[] = new int[nums.length+1];
        // for(int i = 0;i<nums.length;i++)
        //     arr[i+1] = arr[i] + nums[i];
        // int r[] = new int[nums.length];
        // for(int i = 0;i<nums.length;i++)
        //     r[i] = nums[i]%k;
        // int a = 0;
        // int max = 1;
        // for(int i = 1;i<nums.length;i++){
        //     if(r[i]==r[i-1] && i!=nums.length-1)
        //         continue;
        //     else if(i==nums.length-1 && r[i] == r[i-1]){
        //         int l = i-a+1;
        //         if((arr[i+1] - arr[a])%k == r[i])
        //             if(l>max)
        //                 max = l;
        //     }
        //     else{
        //         int l = i - a;
        //         if((arr[i] - arr[a])%k == r[i-1])
        //             if(l>max)
        //                 max = l;
        //         a = i;
        //     }
        // }
        // return max;
    }
    
}