class Solution {
    public int minRotations(String s) {
        int c = 0;
        int p = 0;
        for(int i = 0;i<s.length();i++){
            int d = Math.abs(Integer.valueOf(s.substring(i,i+1)) - p);
            d = Math.min(d,10-d);
            c += d;
            p = Integer.valueOf(s.substring(i,i+1));
        }
        return c;
    }
}