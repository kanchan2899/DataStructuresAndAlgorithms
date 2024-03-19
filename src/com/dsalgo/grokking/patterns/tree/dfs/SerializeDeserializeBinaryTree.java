package com.dsalgo.grokking.patterns.tree.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeBinaryTree {
    private static final String MARKER = "M";
    private static int n = 1;

    public static List<String> serialize(TreeNode root) {
        List<String> stream = new ArrayList<>();
        serializeHelper(root, stream);
        return stream;
    }

    private static void serializeHelper(TreeNode node, List<String> stream) {
        // Adding marker to stream if the node is null
        if(node == null) {
            String s = Integer.toString(n);
            stream.add(MARKER + s);
            n += 1;
            return;
        }

        // adding the node to the stream
        stream.add(String.valueOf(node.val));

        // doing a pre-order traversal for serialization
        serializeHelper(node.left, stream);
        serializeHelper(node.right, stream);
    }
    
    public static TreeNode deserialize(List<String> stream) {
        Collections.reverse(stream);
        TreeNode node = deserializeHelper(stream);
        return node;
    }

    private static TreeNode deserializeHelper(List<String> stream) {
        // pop last element from list
        String val = stream.remove(stream.size() - 1);

        // return null when a marker is encountered
        if(val.charAt(0) == MARKER.charAt(0)) {
            return null;
        }

        // creating a binary tree node from current node value from stream
        TreeNode node = new TreeNode(Integer.parseInt(val));

        // doing a pre-order traversal for deserialization
        node.left = deserializeHelper(stream);
        node.right = deserializeHelper(stream);

        // return node if it exists
        return node;
    }
}
