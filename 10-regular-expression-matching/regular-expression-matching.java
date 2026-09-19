class Solution {
    public boolean isMatch(String s, String p) {
        return f(s,p,s.length()-1,p.length()-1);
    }
    public boolean f(String s,String p,int i,int j){
        if(i<0){
            if(j<0)
                return true;
            if(j<p.length()-1 && p.charAt(j+1) == '*' )
                return f(s,p,i,j-1);
            if( p.charAt(j) == '*' )
                return f(s,p,i,j-1);
            return false;
        }
        if(j<0)
            return false;
        if(j<p.length()-1 && p.charAt(j+1) == '*'){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.')
                return f(s,p,i-1,j) || f(s,p,i,j-1);
            return f(s,p,i,j-1);
        }
        if(p.charAt(j) == '.')
            return f(s,p,i-1,j-1);
        if(p.charAt(j) == '*')
            return f(s,p,i,j-1);
        if(s.charAt(i) == p.charAt(j))
            return f(s,p,i-1,j-1);
        return false;
    }
}