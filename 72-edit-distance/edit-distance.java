class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][]=new Integer[word1.length()+1][1+word2.length()];
        return f(dp,word1.length(),word2.length(),word1,word2);
    }
    public int f(Integer dp[][],int i,int j,String s1,String s2){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)) 
            return dp[i][j] = f(dp,i-1,j-1,s1,s2);

        return dp[i][j] = 1+Math.min(f(dp,i-1,j,s1,s2),
                Math.min(f(dp,i,j-1,s1,s2),f(dp,i-1,j-1,s1,s2)));
    }
}