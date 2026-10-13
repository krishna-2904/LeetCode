class Solution {
    public int minRotations(int n, String s) {
        int c = 0;
        int p = 0;
        for(int i = 0;i<s.length();i++){
            int a = Integer.valueOf(s.substring(i,i+1));
            c += f(a,p);
            p = a;
        }
        int a = Integer.valueOf(s.substring(n-1,n));
        int max = f(0,s.charAt(0)-'0');
        if(n<s.length())
            max += f(s.charAt(n-1)-'0', s.charAt(n)-'0');
        max -= f(0,s.charAt(n-1)-'0');
        if(n<s.length())
            max-= f(s.charAt(n)-'0',s.charAt(0)-'0');
        int i = 1;
        while(i<n){
            int m = f(s.charAt(i-1)-'0',s.charAt(i)-'0');
            if(n<s.length())
                m += f(s.charAt(n)-'0', s.charAt(n-1)-'0');
            m -= f(s.charAt(i-1)-'0',s.charAt(n-1)-'0');
            if(n<s.length())
                m -= f(s.charAt(n)-'0',s.charAt(i)-'0'); 
            if(m>max)
                max = m;
            i++;
        }
        return c - max;
    }
    public int f(int a,int b){
        return Math.min(Math.abs(a-b),10-Math.abs(a-b));
    }
}