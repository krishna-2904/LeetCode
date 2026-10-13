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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        f(list,1,root,0);
        return list;
    }
    public void f(List<List<Integer>> l,int i,TreeNode root,int d){
        if(root==null)
            return;
        if(d==0){
            if(l.size()>=i){
                l.get(i-1).add(root.val);
            }
            else{
                List<Integer> ll = new ArrayList<>();
                ll.add(root.val);
                l.add(new ArrayList<>(ll));
            }
            f(l,i+1,root.left,1);
            f(l,i+1,root.right,1);
        }
        else{
            if(l.size()>=i){
                l.get(i-1).add(0,root.val);
            }
            else{
                List<Integer> ll = new ArrayList<>();
                ll.add(root.val);
                l.add(new ArrayList<>(ll));
            }
            f(l,i+1,root.left,0);
            f(l,i+1,root.right,0);
        }
    }
}