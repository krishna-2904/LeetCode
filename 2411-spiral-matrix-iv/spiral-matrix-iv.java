/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int arr[][] = new int[m][n];
        for(int i = 0;i<m;i++)
            Arrays.fill(arr[i], -1);
        int u = -1;
        int d = m;
        int l = -1;
        int r = n;
        ListNode temp = head;
        while( u<d || l<r ){
            for(int i = l+1;i<r;i++){
                if(temp==null)
                    return arr;
                arr[u+1][i] = temp.val;
                temp = temp.next;
            }
            u++;
            for(int i = u+1;i<d;i++){
                if(temp==null)
                    return arr;
                arr[i][r-1] = temp.val;
                temp = temp.next;
            }
            r--;
            for(int i = r-1;i>l;i--){
                if(temp==null)
                    return arr;
                arr[d-1][i] = temp.val;
                temp = temp.next;
            }
            d--;
            for(int i = d-1;i>u;i--){
                if(temp==null)
                    return arr;
                arr[i][l+1] = temp.val;
                temp = temp.next;
            }
            l++;
        }
        return arr;
    }
}