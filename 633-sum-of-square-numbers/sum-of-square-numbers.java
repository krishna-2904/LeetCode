class Solution {
    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long)Math.sqrt(c);
        long n = 1;
        while(l<=r){
            n = l*l + r*r;
            if(n==c)
                return true;
            if(n>c)
                r--;
            else
                l++;
        }
        return false;
    }
}