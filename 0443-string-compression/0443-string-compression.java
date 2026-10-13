// Using simple two pointers approach 
// One at first element of the group
// Second for filling the compressions.
class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)
            return 1;
        int a = 0;
        int b = 0;
        for(int i = 1;i<chars.length;i++){
            if(chars[i] == chars[i-1]){
                if(i<chars.length-1)
                    continue;
                char ch[] = f(i-a+1);
                chars[b++] = chars[a];
                for(int j = 0;j<ch.length;j++)
                    chars[b++] = ch[j];
            }
            else{
                if(i-a==1){
                    chars[b++] = chars[a];
                }
                else{
                    char ch[] = f(i-a);
                    chars[b++] = chars[a];
                    for(int j = 0;j<ch.length;j++){
                        chars[b++] = ch[j];
                    }
                }
                a = i;
                if(i==chars.length-1){
                    chars[b++] = chars[i];
                }
            }
        }
        return b;
    }
    public char[] f(int n){
        int a = n;
        int c = 0;
        while(a!=0){
            c++;
            a = a/10;
        }
        char ch[] = new char[c];
        for(int i = c-1;i>=0;i--){
            ch[i] = (char)((n%10)+'0');
            n = n/10;
        }
        for(int i = 0;i<ch.length;i++)
            System.out.print(ch[i]+" ");
        System.out.println();
        return ch;
    }
}