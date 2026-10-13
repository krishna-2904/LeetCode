class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int arr[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 0;i<=s1.length();i++){
            Arrays.fill(arr[i],0);
        }
        for(int i = 1;i<=s1.length();i++){
            for(int j = 1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + s1.charAt(i-1);
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        int a = 0;
        for(int i = 0;i<s1.length();i++)
            a += s1.charAt(i);
        for(int j = 0;j<s2.length();j++)
            a+= s2.charAt(j);
        return a - (arr[s1.length()][s2.length()] * 2);
    }
}