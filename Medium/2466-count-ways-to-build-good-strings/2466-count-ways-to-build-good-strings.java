// In this question there was no actual need to create string or even use strings you just have to keep the count.
// So remember focus on what is asked don't complicate the question
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];
        dp[0] = 1;
        for(int i = 0;i<dp.length;i++){
            if(i+zero<dp.length){
                dp[i+zero] = (dp[i+zero] + dp[i]) % 1000000007;
            }
            if(i+one < dp.length){
                dp[i+one] = (dp[i+one] + dp[i]) % 1000000007;
            }
        }
        int sum = 0;
        for(int i = low;i<=high;i++){
            sum = (sum + dp[i]) % 1000000007;
        }
        return sum;
    }
}