class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int t[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if(grid[i][j]==1){
                        q.offer(new int[]{i,j});
                        grid[i][j] = 0;
                        f(q,grid,t);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    public void f(Queue<int[]> q,int g[][],int t[][]){
        int i = q.peek()[0];
        int j = q.poll()[1];
        for(int k = 0;k<4;k++){
            int x = i + t[k][0];
            int y = j + t[k][1];
            if(x<0 || y<0 || x==g.length || y==g[0].length || g[x][y]==0)
                continue;
            q.offer(new int[]{x,y});
            g[x][y] = 0;
        }
        if(!q.isEmpty())
            f(q,g,t);
    }
}