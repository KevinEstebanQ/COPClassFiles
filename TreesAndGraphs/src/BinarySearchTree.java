public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void add(int val){
        BSTNode newNode = new BSTNode(val);

        if(root == null){ root = newNode;
            return;
        }
        /*
        keep track of current node while updating the future to-be parent node on each loop
        when loop ends (current == null) the the parent would we the last non null node found that
        matches the equality checks.
        */
        BSTNode parent = null;
        BSTNode curr = root;

        while(curr != null){
            parent = curr;
            if(curr.value > val){
                curr = curr.left;

            } else if(curr.value < val){
                curr = curr.right;

            } else {
                break;
            }
        }

        if(val > parent.value){
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

    }
    //return a given node based on val
    public BSTNode search(int val){
        return searchNodeRecursive(root, val);
    }
    //recursive private approach to find value
    private BSTNode searchNodeRecursive(BSTNode current, int val){
        if(current == null ){
            return null;
        }
        if(current.value == val){
            return current;
        } else if(current.value > val) {
            return searchNodeRecursive(current.left, val);
        } else if(current.value < val){
            return searchNodeRecursive(current.right, val);
        }
        return null;
    }
    //using non recursive approach
    public BSTNode Search(int val){
        BSTNode current = root;
        if(current == null){
            return null;
        }

        while(current != null){
            if(current.value == val){ return current;}
            else if(current.value > val){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public boolean remove(int val) {
        BSTNode parent = null;
        BSTNode currentNode = root;

        // Search for the node
        while (currentNode != null) {
            // Check if currentNode has a matching key
            if (currentNode.value == val) {
                if (currentNode.left == null && currentNode.right == null) {
                    // Remove leaf

                    if (parent == null) { // Node is root
                        root = null;
                    }
                    else if (parent.left == currentNode) {
                        parent.left = null;
                    }
                    else {
                        parent.right = null;
                    }

                    return true; // Node found and removed
                }
                else if (currentNode.left != null && currentNode.right == null) {
                    // Remove node with only left child

                    if (parent == null) { // Node is root
                        root = currentNode.left;
                    }
                    else if (parent.left == currentNode) {
                        parent.left = currentNode.left;
                    }
                    else {
                        parent.right = currentNode.left;
                    }

                    return true; // Node found and removed
                }
                else if (currentNode.left == null && currentNode.right != null) {
                    // Remove node with only right child

                    if (parent == null) { // Node is root
                        root = currentNode.right;
                    }
                    else if (parent.left == currentNode) {
                        parent.left = currentNode.right;
                    }
                    else {
                        parent.right = currentNode.right;
                    }

                    return true; // Node found and removed
                }
                else {
                    // Remove node with two children

                    // Find successor (leftmost child of right subtree)
                    BSTNode successor = currentNode.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }

                    currentNode.value = successor.value; // Copy successor to current node
                    parent = currentNode;
                    currentNode = currentNode.right; // Remove successor from right subtree
                    val = successor.value;             // Loop continues with new key
                }
            }
            else if (currentNode.value < val) {
                // Search right

                parent = currentNode;
                currentNode = currentNode.right;
            }
            else {
                // Search left

                parent = currentNode;
                currentNode = currentNode.left;
            }
        }

        return false; // Node not found
    }

    public void printOrder(){
        printOrderPrivate(root);
    }
    private void printOrderPrivate(BSTNode node){
        if(node == null){
            return;
        }
        printOrderPrivate(node.left);
        System.out.println(node.value+ " ");
        printOrderPrivate(node.right);
    }
}
