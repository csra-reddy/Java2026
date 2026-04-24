public class MyTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(Node root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        MyTree tree = new MyTree();
    }
}
