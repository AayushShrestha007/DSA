class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

class ParentNode {
    TreeNode parent;

    ParentNode(TreeNode parent) {
        this.parent = parent;
    }
}

public class test {

    public boolean areBrothers(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        ParentNode parentX = new ParentNode(null);
        ParentNode parentY = new ParentNode(null);

        findParents(root, null, x, y, parentX, parentY);

        if (parentX.parent != null && parentY.parent != null) {
            return parentX.parent != parentY.parent;
        }

        return false;
    }

    private void findParents(TreeNode node, TreeNode parent, int x, int y, ParentNode parentX, ParentNode parentY) {
        if (node == null) {
            return;
        }

        if (node.val == x) {
            parentX.parent = parent;
        } else if (node.val == y) {
            parentY.parent = parent;
        }

        findParents(node.left, node, x, y, parentX, parentY);
        findParents(node.right, node, x, y, parentX, parentY);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int x = 4;
        int y = 7;

        test solution = new test();
        boolean result = solution.areBrothers(root, x, y);
        System.out.println("Are " + x + " and " + y + " brothers? " + result);
    }
}
