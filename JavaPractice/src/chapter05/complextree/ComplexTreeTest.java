package chapter05.complextree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.tree.TreeNode;

import org.junit.Test;

public class ComplexTreeTest {

    @Test
    public void insert() {
        final Node<Integer> root = new Node<>(7, null, null);
        root.setLeft(new Leaf<>(root));
        root.setRight(new Leaf<>(root));

        root.insert(3);
        assertTrue(root.search(3));
        assertFalse(root.search(13));
    }

    // private boolean isBST(Node root, int min, int max) {
    //
    // if (root == null)
    // return true;
    // if (root.getValue().compareTo(min) < 0 || root.getValue().compareTo(max)
    // > 0)
    // return false;
    //
    // }



    @Test
    public void checkIfBST() {

        final Node<Integer> root = new Node<>(7, null, null);
        root.setLeft(new Leaf<>(root));
        root.setRight(new Leaf<>(root));
        root.insert(3);
        root.insert(5);
        root.insert(11);

        // assertTrue(isBST1(root));
    }
}
