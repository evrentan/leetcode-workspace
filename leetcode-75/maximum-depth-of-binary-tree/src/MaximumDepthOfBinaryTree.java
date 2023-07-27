

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println("*******Example 1**********");
        TreeNode treeNodeExample1 = new TreeNode(3);
        treeNodeExample1.left = new TreeNode(9);
        treeNodeExample1.right = new TreeNode(20);
        treeNodeExample1.right.left = new TreeNode(15);
        treeNodeExample1.left.right = new TreeNode(7);
        maximumDepthOfBinaryTree.printBST(treeNodeExample1);
        System.out.println();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(treeNodeExample1));

        System.out.println("*******Example 2**********");
        TreeNode treeNodeExample2 = new TreeNode(3);
        treeNodeExample2.right = new TreeNode(2);
        maximumDepthOfBinaryTree.printBST(treeNodeExample2);
        System.out.println();
        System.out.println(maximumDepthOfBinaryTree.maxDepth(treeNodeExample2));
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;

        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);

        return Math.max(leftDepth, rightDepth);
    }

    private void printBST(TreeNode root) {
        if (root == null)
            return;

        printBST(root.left);
        System.out.print(root.val + " ");
        printBST(root.right);

    }
}