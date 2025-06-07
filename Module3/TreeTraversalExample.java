package Module3;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class TreeTraversalExample {

    // In-Order Traversal: Useful for retrieving sorted data from a binary search
    // tree
    // Example: Extracting sorted data for a report
    public void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Pre-Order Traversal: Useful for copying a tree structure or evaluating
    // expressions
    // Example: Serializing a tree structure for storage or transmission
    public void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Post-Order Traversal: Useful for deleting a tree or evaluating postfix
    // expressions
    // Example: Deleting a tree or calculating mathematical expressions
    public void postOrder(TreeNode node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // BFS Traversal: Useful for finding the shortest path or level-by-level
    // processing
    // Example: Finding the shortest path in a graph or rendering UI elements
    // layer-by-layer
    public void bfs(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    public static void main(String[] args) {
        // Create a sample tree:
        // 1
        // / \
        // 2 3
        // / \ \
        // 4 5 6
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        root.right.right.right.right.right = new TreeNode(6);

        TreeTraversalExample traversal = new TreeTraversalExample();

        System.out.println("In-Order Traversal (Sorted Data):");
        traversal.inOrder(root); // Output: 4 2 5 1 3 6

        System.out.println("\nPre-Order Traversal (Tree Structure):");
        traversal.preOrder(root); // Output: 1 2 4 5 3 6

        System.out.println("\nPost-Order Traversal (Tree Cleanup):");
        traversal.postOrder(root); // Output: 4 5 2 6 3 1

        System.out.println("\nBFS Traversal (Level-by-Level):");
        traversal.bfs(root); // Output: 1 2 3 4 5 6
    }
}
