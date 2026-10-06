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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode t1 = null;
        ListNode t2 = null;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                if(h1==null){
                    h1 = temp;
                    t1 = temp;
                }
                else{
                    t1.next = temp;
                    t1 = t1.next;
                }
            }
            else{
                if(h2==null){
                    h2 = temp;
                    t2 = temp;
                }
                else{
                    t2.next = temp;
                    t2 = t2.next;
                }
            }
            temp = temp.next;
        }
        if(t1==null){
            return h2;
        }
        if(t2!=null)
            t2.next = null;
        t1.next = h2;
        return h1;
    }
}