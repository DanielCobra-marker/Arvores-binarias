class ArvoreRubroNegra {
    private NoRubroNegro root;

    public ArvoreRubroNegra() {
        root = null;
    }

    public void insert(int value) {
        NoRubroNegro newNode = new NoRubroNegro(value);
        if (root == null) {
            root = newNode;
            root.color = Color.BLACK;
        } else {
            insertFixup(insertNode(root, newNode));
        }
    }

    private NoRubroNegro insertNode(NoRubroNegro current, NoRubroNegro newNode) {
        if (newNode.value < current.value) {
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                return newNode;
            } else {
                return insertNode(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                return newNode;
            } else {
                return insertNode(current.right, newNode);
            }
        }
    }

    private void insertFixup(NoRubroNegro node) {
        while (node != root && node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                NoRubroNegro uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                NoRubroNegro uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    private void leftRotate(NoRubroNegro x) {
        NoRubroNegro y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(NoRubroNegro y) {
        NoRubroNegro x = y.left;
        y.left = x.right;
        if (x.right != null) x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null) root = x;
        else if (y == y.parent.right) y.parent.right = x;
        else y.parent.left = x;
        x.right = y;
        y.parent = x;
    }

    public void printTree() {
        printTreeHelper(root, "", true);
    }

    private void printTreeHelper(NoRubroNegro node, String indent, boolean isLeft) {
        if (node != null) {
            System.out.println(indent + (isLeft ? "L----" : "R----") + node.value + "(" + node.color + ")");
            printTreeHelper(node.left, indent + (isLeft ? "|    " : "     "), true);
            printTreeHelper(node.right, indent + (isLeft ? "|    " : "     "), false);
        }
    }

    public static void main(String[] args) {
        ArvoreRubroNegra tree = new ArvoreRubroNegra();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(5);
        tree.printTree();
    }
}