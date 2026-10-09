class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int c = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));  
            }
            else{
                if(st.isEmpty()){
                    if(i<s.length()-1 && s.charAt(i+1)==')'){
                        c = c + 1;
                        i++;
                    }
                    else
                        c = c + 2;
                }
                else if(i<s.length()-1 && s.charAt(i+1)==')')
                {
                    st.pop();
                    i++;
                }
                else if(i<s.length()-1 && s.charAt(i+1)=='('){
                    st.pop();
                    c = c + 1;
                }
                else if(i==s.length()-1){
                    st.pop();
                    c = c + 1;
                }

            }
        }
        c = c + (2*st.size());
        return c;
    }
}