package Data_Structures.Tree;

// Functions in this Tree

// insert() : To insert a new node
// find() : To find a node is present or not
// delete() : To delete a node
// height() : TO find the height of the tree
// min() : To find the minimum value in tree
// equals() : To find whether two trees are equal or not
// isBinarySearchTree() : To chek if given tree is BST or not
// printNodesAtDistance() : To print node at a particular distance

// Traversing in tree and printing values of each node :-
// traverseInOrder() 
// traversePreOrder()
// traversePostOrder()

public class MyBST {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void delete(int value) {
        delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.leftChild = delete(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = delete(node.rightChild, value);
        } else {
            if (node.leftChild == null || node.rightChild == null) {
                Node temp = null;
                temp = node.leftChild == null ? node.rightChild : node.leftChild;

                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                Node successor = getSuccessor(node);
                node.value = successor.value;
                node.rightChild = delete(node.rightChild, successor.value);
                return node;
            }
        }

        return node;
    }

    private Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = node.rightChild;

        while (temp.leftChild != null) {
            temp = temp.leftChild;
        }

        return temp;
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    // O(n)
    private int min(Node root) {
        if (root.leftChild == null && root.rightChild == null) {
            return root.value;
        }

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    // Min Value in Binary Search Tree O(log(n))

    // public int min(){
    // if(root == null){
    // throw new IllegalStateException();
    // }

    // var current = root;
    // var last = current;
    // while(current != null){
    // last = current;
    // current = current.leftChild;
    // }
    // return last.value;
    // }

    public boolean equals(MyBST other) {
        if (other == null) {
            return false;
        }

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }

        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }

}