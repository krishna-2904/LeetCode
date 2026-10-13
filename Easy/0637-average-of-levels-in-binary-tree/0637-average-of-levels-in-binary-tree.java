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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        f(list,root,1);
        List<Double> r = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            double d = 0;
            for(int j = 0;j<list.get(i).size();j++){
                d += list.get(i).get(j);
            }
            d = d/list.get(i).size();
            r.add(d);
        }
        return r;
    }
    public void f(List<List<Integer>> list,TreeNode root,int i){
        if(root==null)
            return;
        if(list.size()>=i){
            list.get(i-1).add(root.val);
        }
        else{
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            list.add(l);
        }
        f(list,root.left,i+1);
        f(list,root.right,i+1);
    }
}