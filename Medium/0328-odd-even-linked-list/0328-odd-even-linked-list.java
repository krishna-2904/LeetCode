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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode t1 = null;
        ListNode t2 = null;
        ListNode temp = head;
        h1 = head;
        t1 = h1;
        h2 = head.next;
        t2 = h2;
        temp = h2.next;
        int a = 1;
        while(temp!=null){
            if(a%2==1){
                t1.next = temp;
                t1 = t1.next;
            }
            else{
                t2.next = temp;
                t2 = t2.next;
            }
            temp = temp.next;
            a++;
        }
        t2.next = null;
        t1.next = h2;
        return h1;
    }
}