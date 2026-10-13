class Solution {
    public boolean isNumber(String s) {
        int a = 0;
        int b = s.length()-1;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='e' || s.charAt(i)=='E'){
                b = i-1;
                if(!f(s,i+1,s.length()-1))
                    return false;
            }
        }
        if(f2(s,0,b))
            return true;
        return false;
    }
    public boolean f3(String s,int a,int b){
        int t;
        for(int i = a;i<=b;i++){
            t = s.charAt(i) - '0';
            if(t>=0 && t<=9)
                continue;
            return false;
        }
        return true;
    }
    public boolean f2(String s,int a,int b){
        if(b<a)
            return false;
        if(a==b){
            int t = s.charAt(a) - '0';
            if(t>=0 && t<=9)
                return true;
            return false;
        }
        if(b-a==1){
            int t = s.charAt(0) - '0';
            int r = s.charAt(1) - '0';
            if((t>=0 && t<=9) || (r>=0 && r<=9)){

            }
            else
                return false;
        }
        if(s.charAt(0)=='.'){
            return f3(s,1,b);
        }
        int t = s.charAt(0) - '0';
        if((t>=0 && t<=9) || s.charAt(0) == '-' || s.charAt(0)=='+'){
            for(int i = 1;i<=b;i++){
                if(s.charAt(i)=='.'){
                    if(i==1)
                        return f3(s,2,b);
                    if(i==b)
                        return f3(s,1,b-1);
                    if(f3(s,1,i-1) && f3(s,i+1,b))
                        return true;
                    return false;
                }
            }
            return f3(s,1,b);
        }
        return false;
    }
    public boolean f(String s,int a,int b){
        if(b<a)
            return false;
        boolean flag = false;
        for(int i = b;i>a;i--){
            flag = true;
            int t = s.charAt(i)-'0';
            if(t>=0 && t <= 9 ){
                continue;
            }
            else{
                return false;
            }
        }
        int t = s.charAt(a) - '0';
        if(t>=0 && t<=9 )
            return true;
        if(s.charAt(a)=='-' || s.charAt(a)=='+'){
            if(flag)
                return true;
            return false;
        }
        return false;
    }
}