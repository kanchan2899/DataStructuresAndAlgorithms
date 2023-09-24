package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/foldable-binary-trees/
public class FoldableTree {

    Node root;

    /**
     * The idea is to change the left subtree to its mirror then check that left subtree with
     * its right subtree.
     *
     * 1. If tree is empty, then return true.
     * 2. Convert the left subtree to its mirror image
     * 3. Check if the structure of left subtree and right subtree is same and store the result.
     *      a. res = isStructSame(root->left, root->right). isStructSame() recursively compares
     *      structures of two subtrees and returns true if structures are same
     * 4. Revert the changes made in step (2) to get the original tree.
     * 5. Return result res stored in step 3.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static boolean isFoldable(Node root) {
        boolean isFoldable;

        if(root == null) {
            return true;
        }

        mirror(root.left);

        isFoldable = isStructSame(root.left, root.right);

        mirror(root.left);
        
        return isFoldable;
    }

    private static boolean isStructSame(Node left, Node right) {
        if(left == null && right == null) {
            return true;
        }

        if(left != null && right != null
        && isStructSame(left.left, right.left)
        && isStructSame(left.right, right.right)) {
            return true;
        }
        return false;
    }

    private static void mirror(Node node) {
        if(node == null) {
            return;
        }

        Node temp;

        mirror(node.left);
        mirror(node.right);

        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /**
     * The idea is to check the left and right subtree whether they are mirror or not.
     *
     * 1. If tree is empty then return true.
     * 2. Else check if left and right subtrees are structure wise mirrors of each other.
     * Use utility function IsFoldableUtil(root->left, root->right) for this.
     * 3. Checks if n1 and n2 are mirror of each other.
     *      a. If both trees are empty then return true.
     *      b. If one of them is empty and other is not then return false.
     *      c. Return true if following conditions are met
     *          - n1->left is mirror of n2->right
     *          - n1->right is mirror of n2->left
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static boolean isFoldable1(Node root) {
        if(root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private static boolean helper(Node left, Node right) {

        // if both left and right subtrees are null, return true
        if(left == null && right == null) {
            return true;
        }
        // If one of the trees is NULL and other is not, then return false
        if(left == null || right == null) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);

    }


    /**
     * Using BFS:
     *
     * 1. The left child of the left subtree = the right child of the right subtree.
     * Both of them should be not null.
     * 2. The right child of the left subtree = left child of the right subtree.
     * Both of them should be null or not null.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static boolean isFoldable2(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root != null) {
            queue.add(root.left);
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {

            // remove the front two nodes to check for null condition
            Node p = queue.remove();
            Node r = queue.remove();

            // if both are null, continue and check the further elements
            if(p == null && r == null) {
                continue;
            }

            if((p == null && r != null) || (p != null && r == null)) {
                return false;
            }

            // insert in this order
            queue.add(p.left);
            queue.add(r.right);
            queue.add(p.right);
            queue.add(r.left);
        }
        return true;
    }

    public static void main(String[] args) {
        FoldableTree tree = new FoldableTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Is tree foldable? " + isFoldable(tree.root));
        System.out.println("Is tree foldable? " + isFoldable1(tree.root));
        System.out.println("Is tree foldable? " + isFoldable2(tree.root));
    }
}
