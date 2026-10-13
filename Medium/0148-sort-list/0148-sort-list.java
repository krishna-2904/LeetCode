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
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        int c = 0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        int arr[] = new int[c];
        temp = head;
        int k = 0;
        while(temp!=null){
            arr[k++] = temp.val;
            temp = temp.next;
        }
        Arrays.sort(arr);
        temp = head;
        k = 0;
        while(temp!=null){
            temp.val = arr[k++];
            temp  = temp.next;
        }
        return head;
    }
}