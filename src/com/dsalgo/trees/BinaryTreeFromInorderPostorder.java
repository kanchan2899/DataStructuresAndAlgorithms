package com.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

// https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
public class BinaryTreeFromInorderPostorder {
    Node root;

    static int postIndex;
    static HashMap<Integer,Integer> inorderMap = new HashMap<>();

    /**
     * 1. Pick postEnd element from postorder.
     * 2. Create a new tree node tNode with the data as the picked element.
     * 3. Find the picked element’s index in Inorder. Let the index be inIndex.
     * 4. Call constructTree for elements before inIndex and make the built tree as a left subtree
     * of tNode.
     * 5. Call constructTree for elements after inIndex and make the built tree as a right subtree
     * of tNode.
     * 6. return tNode.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param inorder
     * @param postorder
     * @param inorderStart
     * @param inorderEnd
     * @return
     */
    static Node constructTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd,
                              int postStart, int postEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }
        int val = postorder[postEnd];

        Node root = new Node(val);

        // If this node has no children then return
        if(inorderStart == inorderEnd) {
            return root;
        }

        int inorderIndex = searchInorder(inorder, inorderStart, inorderEnd, root.data);

        root.left = constructTree(inorder, postorder, inorderStart,
                inorderIndex - 1, postStart, postStart - inorderStart + inorderIndex - 1);
        root.right = constructTree(inorder, postorder, inorderIndex + 1, inorderEnd,
                postEnd - inorderEnd + inorderIndex, postEnd - 1);

        return root;
    }

    static int searchInorder(int[] inorder, int start, int end, int val) {
        int k;
        for(k = start; k <= end; k++) {
            if(inorder[k] == val) {
                return k;
            }
        }
        return k;
    }

    /**
     * Store the inorder array in a map, so we can search for inorderIndex in O(1) time.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param inorder
     * @param postorder
     * @return
     */
    static Node constructTree1(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postIndex = inorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    static Node helper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {

        if(inorderStart > inorderEnd) {
            return null;
        }

        int val = postorder[postIndex];
        Node root = new Node(val);
        postIndex--;

        if(inorderStart == inorderEnd) {
            return root;
        }

        int inorderIndex = inorderMap.get(val);

        root.right = helper(inorder, postorder, inorderIndex + 1, inorderEnd);
        root.left = helper(inorder, postorder, inorderStart, inorderIndex - 1);

        return root;

    }

    /**
     * Using stack and map:
     * 1. Create a stack and a set of type Node* and initialize an integer postIndex with N-1
     * 2. Run a for loop with p and i, from n-1 to 0
     * 3. Create a new Node with value as postorder[p] and set it as the root node,
     * if it is the first node of our newly created tree
     * 4. Check if the value of stack top is already present in the set, then remove
     * it from the set and set the left child of stack top equal to the new node and
     * pop out the stack top
     * 5. Push the current node into the stack
     * 6. Perform step numbers 3,4 and 5 while p is greater than or equal to zero and
     * postorder[p] is not equal to inorder[i]
     * 7. Set the new node equal to null and while the stack’s top data is equal to
     * the inorder[i], set the node equal to stack top and pop out the stack top
     * 8. If the node is not null then insert the node into the set and push it into
     * the stack also
     * 9. Return root of the newly created tree
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param inorder
     * @param postorder
     * @return
     */
    static Node constructTree2(int[] inorder, int[] postorder) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();

        int postInder = inorder.length - 1;

        Node root = null;

        for(int i = inorder.length - 1, p = inorder.length - 1; p >= 0;) {
            Node node = null;

            do {
                node = new Node(postorder[p]);

                if(root == null) {
                    root = node;
                }

                if(stack.size() > 0) {
                    if(set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.peek().left = node;
                        stack.pop();
                    } else {
                        stack.peek().right = node;
                    }
                }
                stack.push(node);
            } while (postorder[p--] != inorder[i] && p >= 0);

            node = null;

            while (stack.size() > 0 && i >= 0 && stack.peek().data == inorder[i]) {
                node = stack.peek();
                stack.pop();
                i--;
            }

            if(node != null) {
                set.add(node);
                stack.push(node);
            }
        }
        return root;
    }

    static void printTree(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};

        BinaryTreeFromInorderPostorder tree = new BinaryTreeFromInorderPostorder();
        tree.root = constructTree(inorder, postorder, 0, inorder.length - 1,
                0, postorder.length - 1);
        printTree(tree.root);
        System.out.println();
        tree.root = constructTree1(inorder, postorder);
        printTree(tree.root);
        System.out.println();
        tree.root = constructTree2(inorder, postorder);
        printTree(tree.root);
    }
}
