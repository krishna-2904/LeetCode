class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int v[][] = new int[mat.length][mat[0].length];
        int result[][] = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        int t[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j,0});
                    v[i][j] = 1;
                }
            }
        }
        f(q,mat,v,result,t);
        return result;
    }
    public void f(Queue<int[]> q,int mat[][],int v[][],int result[][],int t[][]){
        int i = q.peek()[0];
        int j = q.peek()[1];
        int d = q.poll()[2];
        for(int k = 0;k<4;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0 || y<0 || x==v.length || y==v[0].length || mat[x][y]==0 || v[x][y]==1)
                continue;
            q.offer(new int[]{x,y,d+1});
            v[x][y] = 1;
            result[x][y] = d+1;
        }
        if(!q.isEmpty())
            f(q,mat,v,result,t);
    }
}