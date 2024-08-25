package Tree.PreOrder_Traversal;
import java.util.*;

public class Iterative {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        // res.add(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            res.add(current.val);
            for (int i = current.children.size() - 1; i > -1; i--) {
                Node child = current.children.get(i);
                stack.push(child);
            }
        }
        return res;

    }
}