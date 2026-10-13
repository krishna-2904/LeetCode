class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list = new ArrayList<>();
        f(list,map,"",digits,0);
        return list;
    }
    public void f(List<String> list,HashMap<Character,String> map, String s, String d,int i){
        if(i==d.length()){
            list.add(s);
            return;
        }
        for(int j = 0;j<map.get(d.charAt(i)).length();j++){
            f(list,map,s + map.get(d.charAt(i)).substring(j,j+1),d,i+1);
        }
        return;
    }
}