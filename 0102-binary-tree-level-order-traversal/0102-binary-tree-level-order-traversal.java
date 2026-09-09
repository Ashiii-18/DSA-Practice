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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }

        Queue <TreeNode> q =new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List <Integer> l = new ArrayList<>(); 
            for(int i=0;i<size;i++){
                TreeNode curnode = q.remove();
                l.add(curnode.val);
                if(curnode.left !=null){
                    q.add(curnode.left);
                }
                if(curnode.right !=null){
                    q.add(curnode.right);
                }
            }
            ans.add(l);
        }
        return ans;
    }
}