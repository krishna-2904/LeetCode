// This question was solved in 22 minutes and simply used the binary numbering logic that all the combinations with a digits and rest n digits will be same if we changed the digit but so simply find that which digit is falling in that number which is being asked.

// Used ArrayList because after using a value we also have to remove that value so arraylist is the best data structure we can use because it can add or remove variables unlike array whose length is assigned once in the starting.
class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1;i<=n;i++)
            arr.add(i);
        String s = "";
        for(int i = n;i>0;i--){
            int f = fact(i);
            k = k%f;
            int a = digit(arr,f,k);
            s = s + String.valueOf(a);
        }
        return s;
    }
    public int digit(ArrayList<Integer> arr,int f,int k){
        if(k==0){
            int a = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            return a;
        } 
        int t = f/arr.size();
        int a = t;
        int c = 0;
        while(a<=f){
            if(k <= a)
                break;
            a = a + t;
            c++;
        }
        int s = arr.get(c);
        arr.remove(c);
        return s;
    }
    public int fact(int n){
        int s = 1;
        for(int i = 2;i<=n;i++){
            s = s * i;
        }
        return s;
    }
}