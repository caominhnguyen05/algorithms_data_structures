package Tree.PostOrder_Traversal;
import java.util.*;
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postorder(root, res);
        return res;
    }

    private void postorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postorder(child, res);
        }
        res.add(root.val);
    }
}
