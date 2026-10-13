class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,Comparator.comparingInt(String::length));
        HashMap<String,Integer> map = new HashMap<>();
        int dp[] = new int[words.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 0;i<words.length;i++){
            for(int j = 0;j<i;j++){
                if(f(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
    public boolean f(String s1,String s2){
        int t = 1;
        if(s2.length()!=s1.length()+1)
            return false;
        int i = 0;
        int j = 0;
        while(i<s1.length() && j<s2.length()){
            if(i==s1.length() && t==1)
                return true;
            if(i==s1.length() && t!=1)
                return false;
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else if(t==1){
                j++;
                t--;
            }
            else
                return false;
        }
        return true;
    }
}