public class Main {
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