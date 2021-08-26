package reversetreenode;

public class ReadTreeNode {
    public static void main(String[] args) {
        TreeNode root = setTree(new TreeNode(), 1);
        preReadTree(root);
        System.out.println("");
        midReadTree(root);
        System.out.println("");
        aftReadTree(root);
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode() {

        }
        public TreeNode(int x) {
            this.value = x;
        }
    }

    static public TreeNode setTree(TreeNode root, int value) {
//        root.value = value;
//        if (value  > 7) {
//            return root;
//        }
//        root.left = new TreeNode();
//        root.right = new TreeNode();
//        setTree(root.left, value + 1);
//        setTree(root.right, value +1);
//        return root;
        root.value = value;
        root.left = new TreeNode(++value);
        root.left.left = new TreeNode(++value);
        root.left.right = new TreeNode(++value);

        root.right = new TreeNode(++value);
        root.right.left = new TreeNode(++value);
        root.right.right = new TreeNode(++value);
        return root;
    }

    static public void preReadTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value);
        preReadTree(root.left);
        preReadTree(root.right);
    }
    static public void midReadTree(TreeNode root) {
        if (root == null) {
            return;
        }
        midReadTree(root.left);
        System.out.print(root.value);
        midReadTree(root.right);
    }
    static public void aftReadTree(TreeNode root) {
        if (root == null) {
            return;
        }
        aftReadTree(root.left);
        aftReadTree(root.right);
        System.out.print(root.value);
    }
}
