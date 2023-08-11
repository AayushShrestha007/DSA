class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Question4B {

    private TreeNode xParent = null;
    private TreeNode yParent = null;
    private int xDepth = -1;
    private int yDepth = -1;

    public boolean areBrothers(TreeNode root, int x, int y) {
        // Find nodes with values x and y, along with their depths and parents
        findNodes(root, null, x, y, 0);

        // Check if both nodes were found and meet the conditions for being brothers
        if (xParent != null && yParent != null) {
            return xParent != yParent && xDepth == yDepth;
        }

        return false;
    }

    private void findNodes(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) {
            return;
        }

        // Check if the current node is the node with value x
        if (node.val == x) {
            xParent = parent; // Update the parent of node x
            xDepth = depth;   // Update the depth of node x
        }
        // Check if the current node is the node with value y
        else if (node.val == y) {
            yParent = parent; // Update the parent of node y
            yDepth = depth;   // Update the depth of node y
        }

        // Recursively search in the left and right subtrees
        // with updated parent and increased depth
        findNodes(node.left, node, x, y, depth + 1);
        findNodes(node.right, node, x, y, depth + 1);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // // uncomment the val below and change x and y value with 5 and 6 respectively to return a true answer
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);

        int x = 3;
        int y = 4;

        Question4B solution = new Question4B();
        boolean result = solution.areBrothers(root, x, y);
        System.out.println("Are " + x + " and " + y + " brothers? " + result);
    }
}


