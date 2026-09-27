class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)=='(')
                st.push(i);
            if(s.charAt(i)==')'){
                int a = st.pop();
                String ss = "";
                if(a>0)
                    ss = s.substring(0,a);
                ss = ss + rev(s,a,i);
                if(i<s.length()-1)
                    ss = ss + s.substring(i+1,s.length());
                s = ss;
                i = i - 2;
            }
            i++;
        }
        return s;
    }
    public String rev(String s,int a,int b){
        int i = b-1;
        String ss = "";
        while(i>a){
            ss = ss + s.charAt(i);
            i--;
        }
        System.out.println(s+" "+a+" "+b+" "+ss);
        return ss;
    }
}