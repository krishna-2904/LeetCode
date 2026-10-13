class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<>();
        int a = n;
        while(n!=1){
            a = f(a);
            if(a==1)
                return true;
            if(s.contains(a))
                return false;
            s.add(a);
        }
        return true;
    }
    public int f(int n){
        if(n==0)
            return 0;
        return (n%10)*(n%10) + f(n/10);
    }
}