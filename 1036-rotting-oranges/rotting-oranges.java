class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int t[][] = new int[4][2];
        t[0][0] = -1;
        t[1][1] = 1;
        t[2][0] = 1;
        t[3][1] = -1;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j,0});
            }
        }
        int temp = 0;
        if(!q.isEmpty())
            temp = f(q,grid,t);
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return temp;
    }
    public int f(Queue<int[]> q,int g[][],int t[][]){
        int arr[] = q.poll();
        int i = arr[0];
        int j = arr[1];
        int m = arr[2];
        for(int k = 0;k<4;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0 || y<0 || x==g.length || y==g[0].length || g[x][y]!=1)
                continue;
            q.offer(new int[]{x,y,m+1});
            g[x][y] = 2;
        }
        if(!q.isEmpty())
            return f(q,g,t);
        return m;
    }
}