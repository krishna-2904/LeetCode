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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return f(head,null);
    }
    public TreeNode f(ListNode l,ListNode h){
        if( l == null || (h!=null && l == h))
            return null;
        ListNode p1 = l;
        ListNode p2 = l;
        while(p2!=h){
            p2 = p2.next;
            if(p2==h)
                break;
            p2 = p2.next;
            p1 = p1.next;
        }
        TreeNode n = new TreeNode(p1.val);
        n.left = f(l,p1);
        n.right = f(p1.next,h);
        return n;
    }
}