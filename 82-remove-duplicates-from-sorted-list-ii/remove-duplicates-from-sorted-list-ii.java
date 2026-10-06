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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) 
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head.next;
        while(temp!=null){
            if(curr.val!=temp.val){
                prev = curr;
                curr = temp;
                temp = temp.next;
            }
            else{
                while(temp!=null && temp.val==curr.val){
                    temp = temp.next;
                }
                if(prev==null){
                    head = temp;
                }
                if(prev!=null)
                    prev.next = temp;
                curr = temp;
                if(temp!=null){
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}