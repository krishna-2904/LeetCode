class Solution {
    public boolean canAliceWin(int n) {
        int a = 10;
        int b = 9;
        while(n>=0){
            if(n>=a){
                n = n - a;
                a -= 2;
                if(n>=b){
                    n = n - b;
                    b -= 2;
                }
                else{
                    return true;
                }
            }
            else
                return false;
        }
        return true;
    }
}