class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        f(list,"",n,n,0);
        return list;
    }
    public void f(List<String> list,String s,int a,int b,int c){
        if(a==0 && b==0 && c==0){
            list.add(s);
            return ;
        }
        if(b==0 || (a==0 && b!=0 && c==0))
            return;
        if(a==0){
            f(list,s + ")",0,b-1,c-1);
            return;
        }
        if(c==0){
            f(list,s + "(",a-1,b,c+1);
            return;
        }
        if(c!=0){
            f(list,s + ")",a,b-1,c-1);
            f(list,s + "(",a-1,b,c+1);
            return;
        }
    }
}