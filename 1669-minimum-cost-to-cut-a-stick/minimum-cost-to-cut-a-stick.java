class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int dp[][] = new int[cuts.length][cuts.length];
        for(int i = 0;i<cuts.length;i++)
            Arrays.fill(dp[i],-1);
        return f(dp,cuts,0,cuts.length-1,0,n);
    }
    public int f(int dp[][],int cuts[],int i,int j,int a,int b){
        if(j==i)
            return b-a;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
            int left = 0;
            int right = 0;
            if(k>i)
                left = f(dp,cuts,i,k-1,a,cuts[k]);
            if(k<j)
                right = f(dp,cuts,k+1,j,cuts[k],b);
            min = Math.min(min,left+right);
        }
        return dp[i][j] = min + b-a;
    }
}
// class Solution {
//     public int minCost(int n, int[] cuts) {
//         int dp[][] = new int[n+1][n+1];
//         for(int i = 0;i<dp.length;i++)
//             Arrays.fill(dp[i],-1);
//         return f(dp,cuts,0,n);
//     }
//     public int f(int dp[][],int arr[],int a,int b){
//         int min = Integer.MAX_VALUE;
//         int curr = b-a;
//         if(dp[a][b] != -1)
//             return dp[a][b];
//         for(int i = 0;i<arr.length;i++){
//             if(arr[i]>a && arr[i]<b){
//                 int left = f(dp,arr,a,arr[i]);
//                 int right = f(dp,arr,arr[i],b);
//                 min = Math.min(left+right,min);
//             }
//         }
//         if(min==Integer.MAX_VALUE)
//             return dp[a][b] = 0;
//         min = min + curr;
//         return dp[a][b] = min;
//     }
// }