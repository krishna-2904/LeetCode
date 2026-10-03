class Solution {
    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        for(int i = 1;i<27;i++)
            set.add(String.valueOf(i));
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return f(set,s,dp,s.length()-1);
    }
    public int f(Set<String> set, String s,int dp[], int i){
        if(i<0)
            return 1;
        if(dp[i]!=-1)
            return dp[i];
        int c = 0;
        if(set.contains(s.substring(i,i+1)))
            c = f(set,s,dp,i-1);
        if(i>0 && set.contains(s.substring(i-1,i+1)))
            c += f(set,s,dp,i-2);
        return dp[i] = c;
    }
}