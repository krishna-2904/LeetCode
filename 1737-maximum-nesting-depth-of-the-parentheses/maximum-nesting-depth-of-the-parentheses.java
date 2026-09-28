class Solution {
    public int maxDepth(String s) {
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
                curr++;
                max = Math.max(max,curr);
            }
            else if(s.charAt(i)==')'){
                st.pop();
                curr--;
            }
        }
        return max;
    }
}