import java.util.*;

public class BSTChecker {
    public static BSTNode checkBSTValidity(BSTNode rootNode) {
        if(rootNode == null)return null;
        HashSet<BSTNode> visited = new HashSet<>();

        return check(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE, visited);
    }
    public static BSTNode check(BSTNode node, Integer min, Integer max, HashSet<BSTNode> visited){
        if (visited.contains(node)) return node;
        visited.add(node);

        int key = node.key;
        if(key <= min || key >= max) return node;

        if(node.left != null){
            BSTNode bad = check(node.left, min, key, visited);
            if (bad != null) return bad;
        }
        if(node.right != null){
            BSTNode bad = check(node.right, key, max, visited);
            if (bad != null) return bad;
        }
        return null;
    }
}