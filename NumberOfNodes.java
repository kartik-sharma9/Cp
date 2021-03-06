public class NumberOfNodes {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        else{
            return (countNodes(root.left) + countNodes(root.right)) + 1;
        }
    }

}
