package Java.Data_Structures.Tree;

public class MyAVLTree {
    private class AVLNode {

        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value: " + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        // Calculating height inside insert method
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        return root;
    }

    public String isHeavy() {

        var balanceFactor = height(root.leftChild) - height(root.rightChild);
        if (balanceFactor > 1) {
            System.out.println(root.value + " is left heavy");
        } else if (balanceFactor < -1) {
            System.out.println(root.value + " is right heavy");
        }

        return "Not Heavy";
    }

    public void balance() {
        balance(root);
    }

    private void balance(AVLNode root) {
        var balanceFactor = height(root.leftChild) - height(root.rightChild);
        if (balanceFactor > 1) {
            if (balanceFactor(root.leftChild) > 0) {
                System.out.println("Left Rotate " + root.leftChild);
            }
            System.out.println("Right Rotate " + root.value);
        } else if (balanceFactor < -1) {
            if (balanceFactor(root.rightChild) > 0) {
                System.out.println("Right Rotate " + root.rightChild);
            }
            System.out.println("Left Rotate " + root.value);
        }
    }

    private int balanceFactor(AVLNode root) {
        return height(root.leftChild) - height(root.rightChild);
    }

    private int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

}
