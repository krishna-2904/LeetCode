class Solution {
    public int[][] generateMatrix(int n) {
        int u = -1;
        int d = n;
        int l = -1;
        int r = n;
        int k = 1;
        int arr[][] = new int[n][n];
        while( u<d || l<r ){
            for(int i = l+1;i<r;i++){
                arr[u+1][i] = k++;
            }
            u++;
            for(int i = u+1;i<d;i++){
                arr[i][r-1] = k++;
            }
            r--;
            for(int i = r-1;i>l;i--){
                arr[d-1][i] = k++;
            }
            d--;
            for(int i = d-1;i>u;i--){
                arr[i][l+1] = k++;
            }
            l++;
        }
        return arr;
    }
}