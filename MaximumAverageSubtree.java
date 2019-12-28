package com.company;

public class MaximumAverageSubtree {
    private class ResultType {
        public int sum, size;

        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeNode subtree = null;
    private ResultType subtreeResult = null;

    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        // Divide and conquer
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // construct the result using left subtree, current node and right subtree.
        ResultType result = new ResultType(
                left.sum + right.sum + root.val,
                left.size + right.size + 1
        );
        // Compare every substree's median with subtreeResult
        if (subtree == null ||
                (subtreeResult.sum / subtreeResult.size) < (result.sum / result.size)
        ) {
            subtree = root;
            subtreeResult = result;
        }
        // Return current result, rather than subtreeResult, because subtreeResult is global
        // subtreeResult is returned in the main function findSubtree
        return result;
    }

    public static void main(String args[]) {
        MaximumAverageSubtree tree = new MaximumAverageSubtree();
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(12);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(23);
        root.right.left = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Level order traversal of binary tree is ");
        TreeNode node = tree.findSubtree(root);
        System.out.println(node.val);
    }
}

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int i) {
        this.val = i;
        left = null;
        right = null;
    }
}