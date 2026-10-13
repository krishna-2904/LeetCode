class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int sum = 0;
        int arr[] = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++)
            arr[i+1] = arr[i] + nums[i];
        int r[] = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
            r[i] = nums[i]%k;
        int a = 0;
        int max = 1;
        for (int i = 1; i <= nums.length; i++) {
            if (i < nums.length && r[i] == r[a])
                continue;
            int len = i - a;
            int rem = r[a];
            int step = rem == 0 ? 1 : k / gcd(rem, k);
            int l = len - (len - 1) % step;
            max = Math.max(max, l);
            a = i;
        }
        return max;
    }
    public int gcd(int a,int b)
    {
        while(b!=0){
            int t = a%b;
            a = b;
            b = t;
        }
        return a;
    }
}