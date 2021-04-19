public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void inorder() {
        inorder(root);
    }
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);

    }
    public boolean search(E e){
            Boolean check = false;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;

                } else if(e.compareTo(current.element)==0){
                    check = true;
                    return check;
                }
            }
            return check;
    }
    public void postorder(){
        if(root==null) return ;
        else {
            inorderLeft();
            System.out.println(root.element + " ");
            inorderRight();
        }
    }
    public void inorderLeft(TreeNode<E> root){
        if(root==null) return ;
        else {
            inorderLeft(root.left);
//            System.out.println(root.element);
        }
    }
    public void inorderLeft(){
        inorderLeft(root);
    }
    public void inorderRight(TreeNode<E> root){
        if(root==null) return ;
        else {
//            System.out.println(root.element);
            inorderRight(root.right);

        }
    }
    public void inorderRight(){
        inorderRight(root);
    }

}