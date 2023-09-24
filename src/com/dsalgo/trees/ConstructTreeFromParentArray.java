package com.dsalgo.trees;

import java.util.Arrays;

// https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
public class ConstructTreeFromParentArray {
    static Node root;

    static void createNode(int[] parent, int i, Node[] created) {
        // if this node is already created
        if(created[i] != null) {
            return;
        }

        // create a new node and set created[i]
        created[i] = new Node(i);

        // if i is root, change root pointer and return
        if(parent[i] == -1) {
            root = created[i];
            return;
        }

        // if parent is not created, then create parent first
        if(created[parent[i]] == null) {
            createNode(parent, parent[i], created);
        }

        // find parent pointer
        Node p = created[parent[i]];

        // if this is first child of parent
        if(p.left == null) {
            p.left = created[i];
        } else {
            p.right = created[i];
        }
    }

    /**
     * Using extra array to store the references of already created nodes
     *
     * 1. Create an array of pointers say created[0..n-1]. The value of created[i] is NULL if node for index i is not created, else value is pointer to the created node.
     * 2. Do following for every index i of given array
     *      a. createNode(parent, i, created)
     *
     *
     *  createNode(parent[], i, created[])
     *
     * 1. If created[i] is not NULL, then node is already created. So return.
     * 2. Create a new node with value ‘i’.
     * 3. If parent[i] is -1 (i is root), make created node as root and return.
     * 4. Check if parent of ‘i’ is created (We can check this by checking if created[parent[i]]
     * is NULL or not.
     * 5. If parent is not created, recur for parent and create the parent first.
     * 6. Let the pointer to parent be p. If p->left is NULL, then make the new node as left child.
     * Else make the new node as right child of parent.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     * @param parent
     * @param n
     * @return
     */
    static Node createTree(int[] parent, int n) {
        Node[] created = new Node[n];


        Arrays.fill(created, null);

        for(int i = 0; i < n; i++) {
            createNode(parent, i, created);
        }

        return root;
    }

    static Node createTree1(int[] parent, int n) {
        Node[] ref = new Node[n];

        Node root = null;

        // create new tree nodes, each having a value from 0 to n - 1 and store them ref
        for(int i = 0; i < n; i++) {
            Node temp = new Node(i);
            ref[i] = temp;
        }

        // Traverse the parent array and build the tree
        for(int i = 0; i < n; i++) {
            if(parent[i] == -1) {
                root = ref[i];
            } else {
                // check if parent's left child is null then map the left child to its parent
                if(ref[parent[i]].left == null) {
                    ref[parent[i]].left = ref[i];
                } else {
                    ref[parent[i]].right = ref[i];
                }
            }
        }

        return root;
    }
    static void inorder(Node root) {
        if(root != null) {
           inorder(root.left);
           System.out.print(root.data + " ");
           inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        ConstructTreeFromParentArray tree = new ConstructTreeFromParentArray();

        Node root = createTree(parent, n);

        inorder(root);
        System.out.println();
        Node root2 = createTree1(parent, n);

        inorder(root2);
    }
}
