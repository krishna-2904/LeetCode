/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode t = node;
        while(t.next.next!=null){
            t.val = t.next.val;
            t = t.next;
        }
        t.val = t.next.val;
        t.next = null;
    }
}