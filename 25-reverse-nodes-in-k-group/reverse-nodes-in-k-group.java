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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = null;
        ListNode e = null;
        ListNode t = head;
        ListNode n = head;
        int a = 0;
        while(n!=null && a<k){
            a++;
            n = n.next;
        }
        h = rev(head,k);
        e = head;
        while(n!=null){
            a = 0;
            t = n;
            while(n != null && a<k){
                a++;
                n = n.next;
            }
            if(a<k){
                e.next = t;
                return h;
            }
            e.next = rev(t,k);
            e = t;
        }
        return h;
    }
    public ListNode rev(ListNode head,int k){
        ListNode t = head;
        int a = 0;
        while(t!=null){
            t = t.next;
            a++;
            if(a>k) break;
        }
        if(a<k) return head;
        t = head;
        ListNode p = null;
        ListNode n = t.next;
        while(t!=null && k>0){
            n = t.next;
            t.next = p;
            p = t;
            t = n;
            k--;
        }
        return p;        
    }
}