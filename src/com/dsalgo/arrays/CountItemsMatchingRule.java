package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-items-matching-a-rule/
public class CountItemsMatchingRule {
    public static void main(String[] args) {
        String ruleKey = "color";
        String ruleValue = "silver";
        List<List<String>> items = new ArrayList<>();
        ArrayList<String> singleList1 = new ArrayList<>();
        singleList1.add("phone");
        singleList1.add("blue");
        singleList1.add("pixel");
        items.add(singleList1);

        System.out.println(countMatches(items, ruleKey, ruleValue));
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index;
        if(ruleKey.contains("type")){
            index = 0;
        } else if(ruleKey.contains("color")){
            index = 1;
        } else{
            index = 2;
        }

        for(List<String> list: items){
            String x = list.get(index);
            if(x.equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}
