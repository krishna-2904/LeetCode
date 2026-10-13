class Solution {
    public int minCut(String s) {
        boolean palin[][] = new boolean[s.length()+1][s.length()+1];
        for(int l = 1;l<=s.length();l++){
            for(int j = 0;j<=s.length()-l;j++){
                palin[j][j+l] = ispalin(palin,s,j,j+l);
            }
        }
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return f(dp,palin,s,0);
    }
    public int f(int dp[],boolean palin[][],String s, int i){
        if(palin[i][s.length()])
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int min = Integer.MAX_VALUE-2000;
        for(int k = i+1;k<=s.length();k++){
            if(palin[i][k]){
                min = Math.min(min,f(dp,palin,s,k));
            }
        }
        return dp[i] = min + 1;
    }
    public boolean ispalin(boolean palin[][],String s,int i,int j){
        if(s.charAt(i)!=s.charAt(j-1))
            return false;
        if(i+1<j-1){
            if(palin[i+1][j-1])
                return true;
            return false;
        }
        return true;
    }
}