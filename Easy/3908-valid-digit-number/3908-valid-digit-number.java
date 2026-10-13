class Solution {
    public boolean validDigit(int n, int x) {
        if(n==0)
            return false;
        boolean f = false;
        while(n>9){
            if(n%10 == x)
                f = true;
            n = n/10;
        }
        if(n==x || !f)
            return false;
        return true;
    }
}