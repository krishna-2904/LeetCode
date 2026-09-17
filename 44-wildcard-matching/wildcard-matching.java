class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length() + 1][p.length() + 1];
        return f(dp,s,p,0,0);
    }
    public boolean f(Boolean dp[][],String s,String p,int i,int j){
        if(i==s.length()){
            if(j==p.length()){
                return true;
            }
            while(j<p.length()){
                if(p.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }
        if(j==p.length())
            return false;
        if(dp[i][j] != null) return dp[i][j];
        if(p.charAt(j) == '?')
        {
            return dp[i][j] = f(dp,s,p,i+1,j+1);
        }
        else if(p.charAt(j) == '*'){
            return dp[i][j] = f(dp,s,p,i,j+1) || f(dp,s,p,i+1,j);
        }
        else if(s.charAt(i) == p.charAt(j))
            return dp[i][j] = f(dp,s,p,i+1,j+1);
        else
            return dp[i][j] = false;
    }
}