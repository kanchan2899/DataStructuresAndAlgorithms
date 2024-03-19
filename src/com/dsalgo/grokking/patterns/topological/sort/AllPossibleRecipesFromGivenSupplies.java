package com.dsalgo.grokking.patterns.topological.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
public class AllPossibleRecipesFromGivenSupplies {
    public static void main(String[] args) {
        String[] recipes = {"bread","sandwich","burger"};
        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast","flour"),
                Arrays.asList("bread","meat"),Arrays.asList("sandwich","meat","bread"));
        String[] supplies = {"yeast","flour"};
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    /**
     * 1. For each recipe, count its non-available ingredients as in degree; Store
     * (non-available ingredient, dependent recipes) as HashMap;
     * 2. Store all 0-in-degree recipes into a list as the starting points of topological sort;
     * 3. Use topological sort to decrease the in degree of recipes, whenever the in-degree
     * reaches 0, add it to return list.
     *
     *
     * @param recipes
     * @param ingredients
     * @param supplies
     * @return
     */
    private static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> allRecipes = new ArrayList<>();
        Set<String> available = Stream.of(supplies).collect(Collectors.toCollection(HashSet::new));
        Map<String, Set<String>> ingredientsToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for(int i = 0; i < recipes.length; i++) {
            int nonAvailable = 0;
            for(String ing: ingredients.get(i)) {
                if(!available.contains(ing)) {
                    ingredientsToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
                    ++nonAvailable;

                }
            }
            if(nonAvailable == 0) {
                allRecipes.add(recipes[i]);
            } else {
                inDegree.put(recipes[i], nonAvailable);
            }
        }
        // topological sort
        for(int i = 0; i < allRecipes.size(); i++) {
            String recipe = allRecipes.get(i);
            if(ingredientsToRecipes.containsKey(recipe)) {
                for(String rcp: ingredientsToRecipes.remove(recipe)) {
                    if(inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        allRecipes.add(rcp);
                    }
                }
            }
        }
        return allRecipes;
    }
}
