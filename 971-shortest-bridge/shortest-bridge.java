class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int v1[][] = new int[n][m];
        int v2[][] = new int[n][m];
        int t[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        int g1[] = new int[2];
        int g2[] = new int[2];
        Queue<int[]> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        boolean flag = true;
        while(i<n && flag){
            j = 0;
            while(j<m && flag){
                if(grid[i][j] == 1 && v1[i][j] == 0)
                {
                    q.offer(new int[]{i,j});
                    g1[0] = i;
                    g1[1] = j;
                    v1[i][j] = 1;
                    f(q,grid,v1,t);
                    flag = false;
                }
                j++;
            }
            i++;
        }
        i = 0;
        j = 0;
        flag = true;
        while(i<n && flag){
            j = 0;
            while(j<m && flag){
                if(grid[i][j] == 1 && v1[i][j] == 0)
                {
                    q.offer(new int[]{i,j});
                    g2[0] = i;
                    g2[1] = j;
                    v2[i][j] = 1;
                    f(q,grid,v2,t);
                    flag = false;
                }
                j++;
            }
            i++;
        }
        int min = Integer.MAX_VALUE;
        for( i = 0;i<n;i++){
            for( j = 0;j<m;j++){
                if(v1[i][j] == 1){
                    for(int k = 0;k<n;k++){
                        for(int l = 0;l<m;l++){
                            if(v2[k][l] == 1){
                                int d = Math.abs(k-i)+Math.abs(l-j)-1;
                                min = Math.min(min,d);
                            }
                        }
                    }
                }
            }
        }
        return min;
    }
    public void f(Queue<int[]> q,int g[][],int v[][],int t[][]){
        int i = q.peek()[0];
        int j = q.poll()[1];
        for(int k = 0;k<4;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0||y<0||x==g.length||y==g[0].length||g[x][y]==0||v[x][y]==1)
                continue;
            q.offer(new int[]{x,y});
            v[x][y] = 1;
        }
        if(!q.isEmpty())
            f(q,g,v,t);
    }
}