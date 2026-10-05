// using recursion will give stack overflow even when using with dp.
// so tabulation is used.
// started filling from last.
// go for all three then store minimum.
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];
        for(int i = days.length-1;i>=0;i--){
            int date = days[i];
            int one = costs[0];
            int week = costs[1];
            int month = costs[2];
            int a = bs(days,date+1);
            if(a<days.length)
                one = one + dp[a];
            a = bs(days,date+7);
            if(a<days.length)
                week = week + dp[a];
            a = bs(days,date+30);
            if(a<days.length)
                month = month + dp[a];
            dp[i] = Math.min(one,Math.min(week,month));
        }
        return dp[0];
    }
    public int bs(int d[],int n){
        if(n>d[d.length-1])
            return d.length;
        int l = 0;
        int h = d.length-1;
        int m = 0;
        while(l<=h){
            m = (l+h)/2;
            if(d[m]==n)
                break;
            if(m>0 && d[m-1]<n && d[m]>n){
                break;
            }
            if(d[m]<n){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return m;
    }
}