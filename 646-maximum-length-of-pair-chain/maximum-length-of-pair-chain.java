class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[0],b[0]));
        int arr[] = new int[pairs.length];
        Arrays.fill(arr,1);
        int max = 0;
        for(int i = 0;i<pairs.length;i++){
            for(int j = 0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    arr[i] = Math.max(arr[i],arr[j]+1);
                }
            }
            max = Math.max(arr[i],max);
        }
        return max;
    }
}