class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        int t[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        q.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        return f(q,t,maze);
    }
    public int f(Queue<int[]> q,int t[][],char maze[][]){
        int i = q.peek()[0];
        int j = q.peek()[1];
        int d = q.poll()[2];
        if((i==0 || j==0 || i==maze.length-1 || j==maze[0].length-1 ) && (d>0)){
            return d;
        }
        for(int k = 0;k<4;k++){
            int x = i+t[k][0];
            int y = j+t[k][1];
            if(x<0||y<0||x==maze.length||y==maze[0].length||maze[x][y]=='+')
                continue;
            q.offer(new int[]{x,y,d+1});
            maze[x][y] = '+';
        }
        if(!q.isEmpty())
            return f(q,t,maze);
        return -1;
    }
}