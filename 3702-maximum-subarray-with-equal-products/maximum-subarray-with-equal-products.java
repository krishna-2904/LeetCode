class Solution {
    public int maxLength(int[] nums) {
        for(int i = nums.length;i>1;i--){
            for(int j = 0;j<nums.length-i+1;j++){
                if(a(nums,j,j+i-1))
                    return i;
            }
        }
        return 1;
    }
    public boolean a(int arr[],int a,int b){
        int p = prod(arr,a,b);
        int l = lcma(arr,a,b);
        int g = gcda(arr,a,b);
        if(p == l*g)
            return true;
        return false;
    }
    public int lcma(int arr[],int a,int b){
        int t = lcm(arr[a],arr[a+1]);
        for(int i = a+2;i<=b;i++)
            t = lcm(t,arr[i]);
        return t;
    }
    public int gcda(int arr[],int a,int b){
        int t = gcd(arr[a],arr[a+1]);
        for(int i = a+2;i<=b;i++)
            t = gcd(t,arr[i]);
        return t;
    }
    public int prod(int arr[],int a,int b){
        int p = 1;
        for(int i = a;i<=b;i++)
            p = p * arr[i];
        return p;
    }
    public int gcd(int a,int b){
        if(b==1){
            return 1;
        }
        if(a%b==0)
            return b;
        return gcd(b,a%b);
    }
    public int lcm(int a,int b){
        int t = Math.max(a,b);
        while(t>0){
            if(t%a==0 && t%b==0)
                return t;
            t++;
        }
        return t;
    }
}