package com.dsalgo.grokking.patterns.graphs;

import java.util.*;

// https://leetcode.com/problems/clone-graph/description/
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class GraphUtility {
        static Node createGraph(int[][] data) {
            if(data.length == 0) {
                return new Node(1);
            }

            Node[] nodes = new Node[data.length];

            for(int i= 0; i < data.length; i++) {
                nodes[i] = new Node(i + 1);
            }

            for(int i = 0; i < data.length; i++) {
                for(int neighbour : data[i]) {
                    nodes[i].neighbors.add(nodes[neighbour - 1]);
                }
            }
            return nodes[0];
        }

        public static List<List<Integer>> create2DList(Node root) {
            // initialize a queue for BFS
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            // initialize a hashmap to keep track of visited nodes
            HashMap<Node, Node> visited = new HashMap<>();

            // initialize a 2D list to store the graph
            List<List<Integer>> graph = new ArrayList<>();

            // initialize a hashmap to store the index of each node
            HashMap<Node, Integer> nodeIndex = new HashMap<>();

            // perform BFS
            while (!queue.isEmpty()) {
                // get the next node in the queue
                Node node = queue.remove();

                // create a new list to store the neighbours of the current node
                List<Integer> neighbours = new ArrayList<>();

                // iterate through the neighbours of the current node
                for(Node neighbour: node.neighbors) {
                    // append the neighbour's value to the current node
                    neighbours.add(visited.getOrDefault(neighbour, neighbour).val);

                    // add the neighbour to the queue if it hasn't been visited yet
                    if(!visited.containsKey(neighbour) && !queue.contains(neighbour)) {
                        visited.put(neighbour, neighbour);
                        queue.add(neighbour);
                    }
                }
            }
            // sort the graph by node value
            Collections.sort(graph, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0) - o2.get(0);
                }
            });

            List<List<Integer>> result = new ArrayList<>();
            for(List<Integer> sublist: result) {
                List<Integer> sub = new ArrayList<>(sublist.subList(1, sublist.size()));
                result.add(sub);
            }
            return result;
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};

        Node root = GraphUtility.createGraph(graph);
        Node clonedGraph = clone(root);
    }

    private static Node clone(Node root) {
        Map<Node, Node> nodesCompleted = new HashMap<>();
        return helper(root, nodesCompleted);
    }

    private static Node helper(Node root, Map<Node, Node> nodesCompleted) {
        // if the root node is None, return None
        if(root == null) {
            return null;
        }

        // create a new node with the same data as the root node
        Node clonedNode = new Node(root.val);

        // add the root node and its clone to the nodesCompleted hash map
        nodesCompleted.put(root, clonedNode);

        // iterate through the neighbours of the root node
        for(Node p : root.neighbors) {
            // retrieve the value of key p in nodesCompleted hashmap.
            // If it exists, assign the corresponding cloned node to x. This check if neighbour
            // node p has already been cloned
            Node x = nodesCompleted.get(p);

            // if the neighbour is not cloned yet, recursively clone it
            if(x == null) {
                clonedNode.neighbors.add(helper(p, nodesCompleted));
            }

            // if the neighbour is already cloned, add the cloned neighbour to the new node's neighbour
            else {
                clonedNode.neighbors.add(x);
            }
        }
        return clonedNode;
    }
}
