/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = head;
        if(head==null) return null;
        while(t2!=null){
            t2 = t2.next;
            t1 = t1.next;
            if(t2==null) return null;
            t2 = t2.next;
            if(t1==t2){
                t1 = head;
                break;
            }
        }
        while(t2!=null){
            if(t1==t2)
                return t1;
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
}