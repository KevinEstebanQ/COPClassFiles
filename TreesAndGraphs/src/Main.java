public class Main {

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(10);
        bst.add(7);
        bst.add(4);
        bst.add(8);
        bst.add(15);
        bst.add(14);
        bst.add(17);
        System.out.println(bst.root.left.right.value);
        BSTNode myNode = bst.search(15);
        BSTNode myNode2 = bst.Search(15);
        System.out.println(myNode.value);
        System.out.println(myNode2.value);

    }
}
