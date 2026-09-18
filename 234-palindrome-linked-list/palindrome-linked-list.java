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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int a = 1;
        while(temp.next!=null){
            a++;
            temp = temp.next;
        }
        Stack<Integer> s = new Stack<>();
        int b = a;
        a = a / 2;
        int i = 0;
        temp = head;
        while(i<a){
            s.push(temp.val);
            i++;
            temp = temp.next;
        }
        if(b%2==1)
            temp = temp.next;
        while(temp!=null){
            if(s.peek() != temp.val)
                return false;
            s.pop();
            temp = temp.next;
        }
        return true;
    }
}