package interview.prep;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Adunuthula on 4/14/2014.
 * Find the maximum width of a binary tree.
 */
public class TreeTraversal<T> {

    public static class Node<T> {
        T elem;
        Node<T> left;
        Node<T> right;

        public Node<T> build(T left, T right) {
            Node<T> leftNode = new Node<T>();
            leftNode.elem = left;

            Node<T> rightNode = new Node<T>();
            rightNode.elem = right;

            this.left = leftNode;
            this.right = rightNode;

            return this;
        }

    }

    public int maxTreeWidth(Node<T> root) {

        if (root == null)
            return 0;

        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        int maxTreeWidth = 1;
        int currentWidth = 0;
        int currentHeight = 1;

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            if (node == null) {
                if (currentWidth > maxTreeWidth)
                    maxTreeWidth = currentWidth;
                System.out.println("Current Height " + currentHeight + " MaxWidth " + maxTreeWidth);
                currentHeight ++;
                if (!queue.isEmpty())
                    queue.add(null);
                currentWidth = 0;
            } else {
                System.out.println("Curent Node: " + node.elem);
                if (node.left != null) {
                    queue.add(node.left);
                    currentWidth++;
                }

                if (node.right != null) {
                    queue.add(node.right);
                    currentWidth++;
                }
            }
        }

        return maxTreeWidth;
    }

}
