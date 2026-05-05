public class testTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);


        //5 -l-> 3 -l-> 2
        tree.dfs();
    }
}