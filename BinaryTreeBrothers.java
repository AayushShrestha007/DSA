class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) { this.val = val; }
TreeNode(int val, TreeNode left, TreeNode right) {
this.val = val;
this.left = left;
  this.right = right;
 }
  }


class Solution {
    int depthX = -1, depthY = -1, parentX = -1, parentY = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        bfs(root, x,y, 0, 0);
        return depthX != -1 && parentX !=-1 &&  parentX != parentY && depthX == depthY;
    }
    
    
    public void bfs(TreeNode root, int x, int y, int depth, int parent) {
        if (root == null) return;
        if (root.val == x) { depthX = depth; parentX = parent; return; }
        else if (root.val == y) { depthY = depth; parentY = parent;  return; }
        bfs(root.left, x,y,depth+1, root.val);
        bfs(root.right, x,y,depth+1, root.val);
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

        Solution solution = new Solution();
        boolean result = solution.isCousins(root, x,y);
        System.out.println("Are " + x + " and " + y + " brothers? " + result);
    }
    
}

   
