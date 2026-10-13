// First approach which is in comments 
// I created a array of n size which is lengths and then calculated for each cut possible in that length which give MLE on n = 8100 because 8100 * 8100 is exceeding the memory limit.

// So I changed my approach to cuts as it will be atmost 100 so no MLE will occur and created a 2d dp of cuts length and at i,j it will store minimum cost to do all cuts between ith index to jth index in cuts.
//inside the function what my approach was that it will try all cuts one by one within that range as a first cut and then move with left part and right part and will return minimum cost required for specific range.
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