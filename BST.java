public class BST {
    BSTNode root;

    public BST(){
        this.root = null;
    }

    public BSTNode insertHelper(BSTNode node, int data) {
        if (node == null) {
            return new BSTNode(data);
        }
       if(node.data > data){
        node.left = insertHelper(node.left, data);
       }
       else {
        node.right = insertHelper(node.right, data);
       }
       return node;
}
public void insert(int data) {
    root = insertHelper(root,data);
}
public void inOrder(BSTNode node){
    if (node == null){
        return;
    }
    inOrder(node.left);
    System.out.print(node.data);
    inOrder(node.right);
}
public boolean search(BSTNode node, int data){
    boolean result = false;

    if (node == null){
        result = false;
        return result;
    }
    if(node.data == data){
        result = true;
    }
    if(node.data > data){
        return search(node.left, data);
    }
    if(node.data < data){
       return search(node.right, data);
    }
    return result;
}
public int height(BSTNode node) {
    if(node == null){
        return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));

}
public int countNodes(BSTNode node) {
    if(node == null){
        return 0;
    }
     return 1 +countNodes(node.left) + countNodes(node.right);
}
public void preOrder(BSTNode node){
    if (node == null){
        return;
    }
    System.out.print(node.data);
    preOrder(node.left);
    preOrder(node.right);
}
public void postOrder(BSTNode node){
    if (node == null){
        return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data);
}
public int findMin(BSTNode node) {
    if(node.left == null){
        return node.data;
    }
    return findMin(node.left);
}
public int findMax(BSTNode node) {
    if(node.right == null){
        return node.data;
    }
    return findMax(node.right);
}
public BSTNode delete(BSTNode node, int data){
    if (node == null) return null;

    if(data < node.data) {
        node.left = delete(node.left, data);
    } else if (data > node.data) {
        node.right = delete(node.right, data);
    } else {
        if (node.left == null && node.right == null){
            return null;
        }
        else if (node.left == null && node.right != null) {
            return node.right;
        }
        else if (node.right == null && node.left != null ){
            return node.left;
        }
        else {
            int successor = findMin(node.right);
            node.data = successor;
            node.right =delete(node.right,successor);
        }
    }
    return node;
}
public static void main(String[] args){
    BST tree = new BST();
    tree.insert(5);
    tree.insert(7);
    tree.insert(4);
    tree.insert(2);
    tree.insert(6);
    tree.insert(1);

    System.out.println("Inorder: ");
    tree.inOrder(tree.root);
    System.out.println();

    System.out.println("Preorder: ");
    tree.preOrder(tree.root);
    System.out.println();

    System.out.println("Postorder: ");
    tree.postOrder(tree.root);
    System.out.println();

    System.out.println("Height: " + tree.height(tree.root));
    System.out.println("Count: " + tree.countNodes(tree.root));
    System.out.println("Min: " + tree.findMin(tree.root));
    System.out.println("Max: " + tree.findMax(tree.root));
    System.out.println("Search 6: " + tree.search(tree.root, 6));
    System.out.println("Search 9: " + tree.search(tree.root, 9));

    tree.root = tree.delete(tree.root, 5);
    System.out.println("After deleting 5: ");
    tree.inOrder(tree.root);

}
}