class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> s = new HashSet<>();
        int n = digits.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    if(i!=j && j!=k && k!=i){
                        int num = digits[i];
                        num = num*10 + digits[j];
                        num = num*10 + digits[k];
                        if(num%2==0 && num > 99 && num < 1000)
                        {
                            s.add(num);
                        }
                    }
                }
            }
        }
        int arr[] = new int[s.size()];
        int j = 0;
        for(int i:s){
            arr[j++] = i;
        }
        Arrays.sort(arr);
        return arr;
    }
}