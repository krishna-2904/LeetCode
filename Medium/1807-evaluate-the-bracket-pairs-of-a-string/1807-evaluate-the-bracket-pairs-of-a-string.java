class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> ss:knowledge){
            map.put(ss.get(0),ss.get(1));
        }
        String ss = "";
        int a = 0;
        int i = 0;
        while(i<s.length()){
            while(s.charAt(i)!='('){
                i++;
                if(i==s.length()){
                    ss = ss + s.substring(a,i);
                    return ss;
                }
            }
            ss = ss + s.substring(a,i);
            a = i+1;
            while(i<s.length() && s.charAt(i)!=')'){
                i++;
                if(s.length()==i)
                    return ss;
            }
            if(map.containsKey(s.substring(a,i))){
                ss = ss + map.get(s.substring(a,i));
            }
            else{
                ss = ss + "?";
            }
            a = i+1;
        }
        return ss;
    }
}