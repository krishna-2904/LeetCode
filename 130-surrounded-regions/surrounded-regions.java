class Solution {
    public void solve(char[][] board) {
        int v[][] = new int[board.length][board[0].length];
        int v2[][] = new int[v.length][v[0].length];
        Queue<int[]> q = new LinkedList<>();
        int t[][] = new int[4][2];
        t[0][0] = -1;
        t[1][1] = 1;
        t[2][0] = 1;
        t[3][1] = -1;
        for(int i = 0;i<v.length;i++){
            for(int j = 0;j<v[0].length;j++){
                if(v[i][j]==0 && board[i][j]=='O'){
                    q.add(new int[]{i,j});
                    v[i][j] = 1;
                    if(f1(q,v,t,board,true)){
                        q.add(new int[]{i,j});
                        v2[i][j] = 1;
                        f2(q,v2,t,board);
                    }
                }
            }
        }
    }
    public boolean f1(Queue<int[]> q,int v[][],int t[][],char board[][],boolean flag){
        int i = q.peek()[0];
        int j = q.poll()[1];
        for(int k = 0;k<4;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0 || y<0 || x>=v.length || y>=v[0].length){
                flag = false;
                continue;
            }
            if(board[x][y]=='X' || v[x][y]==1)
                continue;
            q.add(new int[]{x,y});
            v[x][y] = 1;
        }
        if(!q.isEmpty())
            return f1(q,v,t,board,flag);
        return flag;
    }
    public void f2(Queue<int[]> q,int v2[][],int t[][],char board[][]){
        if(q.isEmpty())
            return;
        int i = q.peek()[0];
        int j = q.poll()[1];
        board[i][j] = 'X';
        for(int k = 0;k<4;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0 || y<0 || x==v2.length || y==v2[0].length)
                continue;
            if(board[x][y] == 'X' || v2[x][y] == 1)
                continue;
            q.add(new int[]{x,y});
            v2[x][y] = 1;
        }
        if(!q.isEmpty())
            f2(q,v2,t,board);
        return;
    }
}