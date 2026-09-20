class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        Boolean dp[][] = new Boolean[n+1][flowerbed.length+1];
        return f(dp,flowerbed,flowerbed.length-1,n);
    }
    public boolean f(Boolean dp[][],int arr[],int i,int n){
        if(i<0){
            if(n==0) 
                return true;
            return false;
        }
        if(n==0)
            return true;
        if(dp[n][i] != null) return dp[n][i];
        if(arr[i] == 1)
            return dp[n][i] = f(dp,arr,i-2,n);
        if(i>0){
            if(arr[i-1] == 0 ){
                boolean f1 = f(dp,arr,i-1,n);
                arr[i] = 1;
                boolean f2 = f(dp,arr,i-2,n-1);
                arr[i] = 0;
                return dp[n][i] = f1 || f2;
            }
            else{
                return dp[n][i] = f(dp,arr,i-3,n);
            }
        }
        if(n==1) 
            return true;
        return false;
    }
}