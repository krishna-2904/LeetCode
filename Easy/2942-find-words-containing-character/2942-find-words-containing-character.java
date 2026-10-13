class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            if(f(words[i],x))
                l.add(i);
        }
        return l;
    }
    public boolean f(String s, char x){
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == x)
                return true;
        }
        return false;
    }
}