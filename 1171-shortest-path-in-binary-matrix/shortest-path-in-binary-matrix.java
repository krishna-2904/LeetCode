class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 ||grid[grid.length-1][grid[0].length-1]==1)
            return -1;
        int t[][] = new int[8][2];
        t[0][0] = -1;
        t[1][0] = -1;
        t[1][1] = 1;
        t[2][1] = 1;
        t[3][0] = 1;
        t[3][1] = 1;
        t[4][0] = 1;
        t[5][0] = 1;
        t[5][1] = -1;
        t[6][1] = -1;
        t[7][0] = -1;
        t[7][1] = -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;
        return f(q,grid,t);
    }
    public int f(Queue<int[]> q,int g[][],int t[][]){
        int i = q.peek()[0];
        int j = q.peek()[1];
        int d = q.poll()[2];
        if(i==g.length-1 && j==g[0].length-1)
            return d;
        for(int k = 0;k<8;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0 || y<0 || x==g.length || y==g[0].length || g[x][y]==1 ){
                continue;
            }
            q.offer(new int[]{x,y,d+1});
            g[x][y] = 1;
        }
        if(!q.isEmpty())
            return f(q,g,t);
        return -1;
    }
}