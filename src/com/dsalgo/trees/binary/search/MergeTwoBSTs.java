package com.dsalgo.trees.binary.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
public class MergeTwoBSTs extends BinarySearchTree{

    /**
     * Using Iterative Inorder Traversal:
     *
     * 1. Consider two stacks s1 and s2 which stores the elements of the two trees.
     * 2. Store the left view value of a tree1 in s1 and of tree2 in s2.
     * 3. Compare the top values present in the stack and push the value accordingly in the
     * result vector.
     *      a. If s2 is empty then pop s1 and put the popped node value in the answer vector
     *      b. Else if both s1 and s2 are not empty then compare their top nodes’ value if
     *      s1.top()->val <= s2.top()->val then in this case push the s1.top()->val in the result
     *      vector and push its right child in the stack s1.
     *      c. If s1 is empty then pop s2 and put the popped node value in the answer vector.
     *      d. Else if both s1 and s2 are not empty then compare their top nodes’ value if
     *      s2.top()->val >= s1.top()->val then in this case push the s2.top()->val in the result
     *      vector and push its right child in the stack s2
     *      e. Loop while there are nodes not yet printed. The nodes may be in the stack(explored,
     *      but not printed) or maybe not yet explored
     *
     *  TC: O(m + n)
     *  SC: O(h1 + h2)
     *
     * @param root1
     * @param root2
     * @return
     */
    static List<Integer> mergeTwoBSTs(Node root1, Node root2) {
        List<Integer> merged = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if(stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().data <= stack2.peek().data)) {
                root1 = stack1.peek();
                stack1.pop();
                merged.add(root1.data);
                root1 = root1.right;
            } else {
                root2 = stack2.peek();
                stack2.pop();
                merged.add(root2.data);
                root2 = root2.right;
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        MergeTwoBSTs tree1 = new MergeTwoBSTs();
        MergeTwoBSTs tree2 = new MergeTwoBSTs();

        tree1.root = tree1.insert(null, 3);
        tree1.root.left = tree1.insert(tree1.root, 1);
        tree1.root.right = tree1.insert(tree1.root, 5);

        tree2.root = tree2.insert(null, 4);
        tree2.root.left = tree2.insert(tree2.root, 2);
        tree2.root.right = tree2.insert(tree2.root, 6);

        System.out.println(mergeTwoBSTs(tree1.root, tree2.root));
    }

}
