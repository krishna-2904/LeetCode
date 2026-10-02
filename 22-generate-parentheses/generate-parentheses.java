class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        f(list,"",n*2);
        System.out.println(list.size());
        List<String> result = new ArrayList<>();
        for(String s:list){
            if(c(s)){
                result.add(s);
            }
        }
        return result;
    }
    public boolean c(String s){
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(1);
            else{
                if(st.isEmpty())
                    return false;
                st.pop();
            }
        }
        if(st.isEmpty())
            return true;
        return false;
    }
    public void f(List<String> list,String s,int n){
        if(n==0){
            list.add(s);
            return ;
        }
        String a = s + "(";
        String b = s + ")";
        f(list,a,n-1);
        f(list,b,n-1);
    }
}