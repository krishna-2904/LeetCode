class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        image = f(image,sr,sc,image[sr][sc], color);
        return image;
    }
    public int[][] f(int arr[][],int i,int j,int c,int n){
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length)
        {
            return arr;
        }
        if( arr[i][j] == n || arr[i][j] != c ){
            return arr;
        }
        arr[i][j] = n;
        arr = f( arr, i, j+1, c, n);
        arr = f( arr, i, j-1, c, n);
        arr = f( arr, i+1, j, c, n);
        arr = f( arr, i-1, j, c, n);
        return arr;
    }
}