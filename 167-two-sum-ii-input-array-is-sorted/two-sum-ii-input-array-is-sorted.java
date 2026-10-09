// Simple approach was to start from first index and for each element run a binary search for the remaining element and the complexity came was O(nlogn).
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0;i<numbers.length;i++){
            int a = numbers[i];
            int l = i+1;
            int h = numbers.length-1;
            int m = (l+h)/2;
            while(l<=h){
                m = (l+h)/2;
                // System.out.println(a+" "+numbers[m]);
                if(numbers[m] + a == target){
                    int arr[] = new int[2];
                    arr[0] = i+1;
                    arr[1] = m+1;
                    return arr;
                }
                else if(numbers[m] + a < target){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
                // System.out.println(l+" "+h);
            }
        }
        return numbers;
    }
}