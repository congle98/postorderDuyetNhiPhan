public class demo {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(8);
        tree.insert(10);
        tree.insert(13);
        tree.insert(1);
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.postorder();


    }
}
