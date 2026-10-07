class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> l = new ArrayList<>();
        f(list,l,s);
        return list;
    }
    public void f(List<List<String>> list,List<String> l,String s){
        if(s.isEmpty()){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i = 1;i<=s.length();i++){
            if(ispalin(s.substring(0,i))){
                l.add(s.substring(0,i));
                f(list,l,s.substring(i,s.length()));
                l.remove(l.size()-1);
            }
        }
    }
    public boolean ispalin(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}