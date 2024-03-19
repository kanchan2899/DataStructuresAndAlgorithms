package com.dsalgo.grokking.patterns.topological.sort;

import java.util.*;

public class CompilationOrder {
    public static void main(String[] args) {
        List<List<Character>> dependencies = Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B'));
        System.out.println(findCompilationOder(dependencies));
    }

    private static List<Character> findCompilationOder(List<List<Character>> dependencies) {
        List<Character> sortedOrder = new ArrayList<>();
        // initialize the graph and inDegree
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for(int x = 0; x < dependencies.size(); x++) {
            char parent = dependencies.get(x).get(0);
            char child = dependencies.get(x).get(1);

            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());

            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }

        // build the graph
        for(int dependency = 0; dependency < dependencies.size(); dependency++) {
            char parent = dependencies.get(dependency).get(1);
            char child = dependencies.get(dependency).get(0);

            // put the child into it's parent's list
            graph.get(parent).add(child);

            // increment child's indegree
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // find all sources i.e. all n with 0 indegrees
        Queue<Character> sources = new LinkedList<>();

        for(char key : inDegree.keySet()) {
            if(inDegree.get(key) == 0) {
                sources.add(key);
            }
        }

        // for each source, add it to the sorted_order and subtract one from all of its children's
        // in-degrees if a child's in-degree becomes zero, add it to the source queue
        while (!sources.isEmpty()) {
            char vertex = sources.poll();
            sortedOrder.add(vertex);

            for(int child = 0; child < graph.get(vertex).size(); child++) {
                inDegree.put(graph.get(vertex).get(child), inDegree.get(graph.get(vertex).get(child)) - 1);
                if(inDegree.get(graph.get(vertex).get(child)) == 0) {
                    sources.add(graph.get(vertex).get(child));
                }
            }
        }

        return sortedOrder;
    }
}
