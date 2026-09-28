class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 1;
        while(i<arr.length){
            if(arr[i]<arr[i-1])
                break;
            if(arr[i]==arr[i-1])
                return false;
            i++;
        }
        if(i==1 || i==arr.length)
            return false;
        while(i<arr.length){
            if(arr[i]>=arr[i-1])
                return false;
            i++;
        }
        return true;
    }
}