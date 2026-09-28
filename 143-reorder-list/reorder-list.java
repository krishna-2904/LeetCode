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
    public void reorderList(ListNode head) {
        ListNode head2 = new ListNode(head.val);
        ListNode t1 = head;
        ListNode t2 = head2;
        int l = 1;
        while(t1.next!=null){
            t2.next = new ListNode(t1.next.val);
            t2 = t2.next;
            t1 = t1.next;
            l++;
        }
        head2 = rev(head2);
        t1 = head;
        t2 = head2;
        ListNode temp1 = null;
        ListNode temp2 = null;
        int a = 0;
        while(a<l-1){ 
            System.out.print(t1.val+" "+t2.val);     
            temp1 = t1.next;
            t1.next = t2;
            temp2 = t2.next;
            if(a==l-2){
                t2.next = null;
                return;
            }
            t2.next = temp1;
            t1 = temp1;
            t2 = temp2;
            System.out.println(" "+t1.val+" "+t2.val);
            a += 2;
        }        
        t1.next = null;
    }
    public ListNode rev(ListNode h){
        ListNode p = null;
        ListNode c = h;
        ListNode n = h.next;
        while(c!=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}