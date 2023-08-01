import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        binaryTreeRightSideView.executeFirstExample();
        binaryTreeRightSideView.executeSecondExample();
        binaryTreeRightSideView.executeThirdExample();
        binaryTreeRightSideView.executeFourthExample();
        binaryTreeRightSideView.executeFifthExample();
    }

    private void executeFirstExample() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(4);

        System.out.println("*************Example 1*************");

        System.out.print("BST is: ");
        this.printBST(root);
        System.out.println();

        System.out.println(this.rightSideView(root).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void executeSecondExample() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(3);

        System.out.println("*************Example 2*************");

        System.out.print("BST is: ");
        this.printBST(root);
        System.out.println();

        System.out.println(this.rightSideView(root).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void executeThirdExample() {
        TreeNode root = null;

        System.out.println("*************Example 3*************");

        System.out.print("BST is: ");
        this.printBST(root);
        System.out.println();

        System.out.println(this.rightSideView(root).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void executeFourthExample() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println("*************Example 4*************");

        System.out.print("BST is: ");
        this.printBST(root);
        System.out.println();

        System.out.println(this.rightSideView(root).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void executeFifthExample() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println("*************Example 5*************");

        System.out.print("BST is: ");
        this.printBST(root);
        System.out.println();

        System.out.println(this.rightSideView(root).stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();

        if (root == null)
            return rightSide;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()) {
            int level = treeNodeQueue.size();
            Integer rightMostVal = null;

            for (int i = 0; i < level; i++) {
                TreeNode node = treeNodeQueue.poll();
                rightMostVal = node.val;

                if (node.left != null)
                    treeNodeQueue.add(node.left);

                if (node.right != null)
                    treeNodeQueue.add(node.right);
            }

            rightSide.add(rightMostVal);
        }

        return rightSide;
    }

    private void printBST(TreeNode root) {
        if (root == null)
            return;

        printBST(root.left);
        System.out.print(String.format("%d ", root.val));
        printBST(root.right);
    }
}