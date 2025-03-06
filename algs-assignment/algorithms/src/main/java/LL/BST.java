package LL;

public class BST {

    private Node root;

    private class Node {

        private int key;
        private Node left, right, p;
        private int size;

        public Node(int key, int size) {

            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;

        }

    }

    // public call
    public Node search(int k) {

        return search(root, k);

    }

    // private call for recursion
    private Node search(Node x, int k) {

        if (x == null || k == x.key) {
            return x;
        }
        if (k < x.key) {
            return search(x.left, k);
        } else {
            return search(x.right, k);
        }

    }

    public Node min(Node x) {

        while (x.left != null) {
            x = x.left;
        }

        return x;

    }

    public Node max(Node x) {

        while (x.right != null) {
            x = x.right;
        }

        return x;

    }

    public void insert(Node z) {

        Node x = root;
        Node y = null;

        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.p = y;
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }

    }

    public void transplant(Node u, Node v) {

        if (u.p == null) {
            root = v;
        } else if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }

        if (v != null) {
            v.p = u.p;
        }

    }

    public void delete(Node z) {

        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            Node y = min(z.right);

            if (y.p != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }

    }

    // orderings
    public void inOrder(Node x) {

        if (x != null) {
            inOrder(x.left);
            System.out.println(x.key);
            inOrder(x.right);
        }

    }

    public void preOrder(Node x) {

        if (x != null) {
            System.out.println(x.key);
            preOrder(x.left);
            preOrder(x.right);
        }

    }

    public void postOrder(Node x) {

        if (x != null) {
            postOrder(x.left);
            postOrder(x.right);
            System.out.println(x.key);
        }

    }

    //insert checkBST here

}
