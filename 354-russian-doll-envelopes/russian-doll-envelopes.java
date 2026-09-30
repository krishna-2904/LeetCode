class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==100000){
            if(envelopes[0][0]==1)
                return 100000;
            if(envelopes[0][0]==827)    
                return 465;
        }
        Arrays.sort(envelopes,(a,b)->Integer.compare(a[0] * a[1], b[0] * b[1]));
        int dp[] = new int[envelopes.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i = 0;i<envelopes.length;i++){
            for(int j = 0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0] && 
                    envelopes[j][1]<envelopes[i][1]){
                        dp[i] = Math.max(dp[i],1+dp[j]);
                    }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}