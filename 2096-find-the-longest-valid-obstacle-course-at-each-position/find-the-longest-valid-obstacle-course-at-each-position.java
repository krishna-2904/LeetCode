// There are two arrays 
// First array[i] = longest valid course including i'th position
// Second array is a binary search array created  of size + 1
// bs[i] = i is length and bs[i] = shortest last number of valid subsequences of that size.

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int arr[] = new int[obstacles.length];
        Arrays.fill(arr,1);
        int bs[] = new int[obstacles.length+1];
        Arrays.fill(bs,Integer.MAX_VALUE);
        bs[0] = 0;
        for(int i = 0;i<obstacles.length;i++){
            int index = f(bs,obstacles[i]);
            bs[index] = obstacles[i];
            arr[i] = index;
        }
        return arr;
    }
    public int f(int bs[],int t){
        int l = 1;
        int h = bs.length-1;
        int m = (l+h)/2;
        while(l<h){
            if(bs[m-1]<=t && bs[m]>t)
                return m;
            if(bs[m]<=t){
                l = m+1;
            }
            else {
                h = m-1;
            }
            m = (l+h)/2;
        }
        return m;
    }
}