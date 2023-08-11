class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class Question4B {

    private Node[] findNodeAndParent(Node node, int target, Node parent, int depth) {
        if (node == null) {
            return null;
        }

        if (node.data == target) {
            return new Node[] { node, parent, new Node(depth) };
        }

        Node[] leftResult = findNodeAndParent(node.left, target, node, depth + 1);
        if (leftResult[0] != null) {
            return leftResult;
        }

        Node[] rightResult = findNodeAndParent(node.right, target, node, depth + 1);
        if (rightResult[0] != null) {
            return rightResult;
        }

        return new Node[] { null, null, new Node(-1) };
    }

    public boolean brothers(Node root, int x, int y) {
        Node[] resultX = findNodeAndParent(root, x, null, 0);
        Node[] resultY = findNodeAndParent(root, y, null, 0);

        return resultX[2].data == resultY[2].data && resultX[1] != resultY[1];
    }

    // Test case
    public static void main(String[] args) {
        Question4B tree = new Question4B();

        //Data for showing true
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // int x=5;
        // int y=6; 

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        int x = 4;
        int y = 3;

        System.out.println(tree.brothers(root, x, y)); // Output: false
    }
}
