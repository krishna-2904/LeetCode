class Solution {
    public String intToRoman(int num) {
        String s = "";
        while(num>=1000){
            s = s + "M";
            num = num - 1000;
        }
        if(num >= 900){
            s = s + "CM";
            num = num - 900;
        }
        if(num >= 400 && num <500){
            s = s + "CD";
            num = num - 400;
        }
        else if(num >= 500){
            s = s + "D";
            num = num - 500;
        }
        while(num>=100){
            s = s + "C";
            num = num - 100;
        }
        if(num >= 90){
            s = s + "XC";
            num = num - 90;
        }
        else if (num >= 40 && num < 50){
            s = s + "XL";
            num = num - 40;
        }
        else if ( num >= 50){
            s = s + "L";
            num = num - 50;
        }
        while(num >= 10){
            s = s + "X";
            num = num - 10;
        }
        if(num == 9){
            s = s + "IX";
            num = num - 9;
        }
        else if (num == 4){
            s = s + "IV";
            num = num - 4;
        }
        else if (num >= 5){
            s = s + "V";
            num = num - 5;
        }
        while(num>=1){
            s = s + "I";
            num = num - 1;
        }
        return s; 
    }
}