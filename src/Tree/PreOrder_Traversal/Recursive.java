package Tree.PreOrder_Traversal;
import java.util.*;
public class Recursive {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preorder(root, res);
        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child: root.children) {
            preorder(child, res);
        }
    }
}
