package interview.prep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import interview.prep.TreeTraversal.Node;
/**
 * Created by Adunuthula on 4/14/2014.
 */
public class TreeTraversalTest {


    @Test
    public void testBalancedTree() {
        TreeTraversal<Integer> tt = new TreeTraversal<Integer>();
        Node<Integer> root = new Node<Integer>();
        root.elem = 0;

        root.build(1, 2);
        root.left.build(3,4);
        root.right.build(5, 6);

        int maxWidth = tt.maxTreeWidth(root);
        assertEquals("Max Tree Width", 4, maxWidth);

    }
}
