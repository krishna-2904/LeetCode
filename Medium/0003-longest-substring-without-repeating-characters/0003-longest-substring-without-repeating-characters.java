class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1){return s.length();}
        Set<Character> ss = new HashSet<>();
        int max = 0;
        int c = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(ss.contains(s.charAt(i)))
            {
                max = Math.max(max,c);
                int j = i-1;
                ss = new HashSet<>();
                ss.add(s.charAt(i));
                while(j>=0 && s.charAt(j)!=s.charAt(i)){
                    ss.add(s.charAt(j));
                    j--;
                }
                c = i-j;
            }
            else
            {
                c++;
                ss.add(s.charAt(i));
            }
        }
        max = Math.max(max,c);
        return max;
    }
}