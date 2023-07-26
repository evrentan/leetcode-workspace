public class SearchInABinarySearchTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        SearchInABinarySearchTree searchInABinarySearchTree = new SearchInABinarySearchTree();
        searchInABinarySearchTree.printBST(searchInABinarySearchTree.searchBST(treeNode, 2));
        System.out.println();
        System.out.println("*****************");
        searchInABinarySearchTree.printBST(searchInABinarySearchTree.searchBST(treeNode, 5));

    }

    private TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val)
            return root;
        else if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    private void printBST(TreeNode root) {
        if (root == null)
            return;

        printBST(root.left);
        System.out.print(root.val + " ");
        printBST(root.right);

    }
}