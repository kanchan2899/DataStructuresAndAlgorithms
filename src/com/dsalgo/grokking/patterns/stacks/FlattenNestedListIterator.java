package com.dsalgo.grokking.patterns.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class FlattenNestedListIterator {
    private Stack<NestedInteger> stack;
    static class NestedInteger {
        List<NestedInteger> list;
        int file;

        // Constructor initializes an empty nested list.
        public NestedInteger(){
            this.list = new ArrayList<NestedInteger>();
        }

        // Constructor initializes a single file.
        public NestedInteger(int value){
            this.file = value;
        }
        // @return true if this NestedInteger holds an integer value.
        public boolean isInteger() {
            return isFile();
        }

        // @return true if this NestedDirectories holds a single file, rather than a nested list.
        public boolean isFile(){
            if(this.file != 0)
                return true;
            return false;
        }

        // @return the single file that this NestedDirectories holds, if it holds a single file
        // Return null if this NestedDirectories holds a nested list
        public int getFile(){
            return this.file;
        }

        // Set this NestedDirectories to hold a single file.
        public void setFile(int value){
            this.list = null;
            this.file =  value;
        }

        // Set this NestedDirectories to hold a nested list and adds a nested file to it.
        public void add(NestedInteger ni){
            if (this.file != 0){
                this.list = new ArrayList<NestedInteger>();
                this.list.add(new NestedInteger( this.file));
                this.file = 0;
            }
            this.list.add(ni);
        }

        // @return the nested list that this NestedDirectories holds, if it holds a nested list
        // Return null if this NestedDirectories holds a single file
        public List<NestedInteger> getList(){
            return this.list;
        }
    }

    // NestedIterator constructor initializes the stack using the given nestedList
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            this.stack.push(nestedList.get(i));
        }
    }

    // hasNext() will return true if there are still some integers in the stack and false otherwise
    public boolean hasNext() {
        // iterate the stack until it is empty
        while (!stack.isEmpty()) {
            // save the top value of the stack
            NestedInteger top = stack.peek();

            // check if the top value is integer, if true return True, if not continue
            if(top.isFile()) {
                return true;
            }

            // if the top is not an integer, it must be the list of integers
            // pop the list from the stack and save it in the top_list
            List<NestedInteger> topList = stack.pop().getList();

            for(int i = topList.size() - 1; i >= 0; i--) {
                // append the values of the nested list onto the stack
                this.stack.push(topList.get(i));
            }
        }
        return false;
    }

    public int next() {
        // check if there is still an integer in the stack
        if(hasNext()) {
            return this.stack.pop().getFile();
        }
        return 0;
    }

    public static void main(String[] args) {
        List<FlattenNestedListIterator> itr = new ArrayList<>();

        List<NestedInteger> nestedList = new ArrayList<>();
        NestedInteger l3 = new NestedInteger();
        nestedList.add(l3);
        nestedList.add(new NestedInteger(3));
        l3.add(new NestedInteger(2));
        l3.add(new NestedInteger(3));
        l3.add(new NestedInteger(4));
        l3.add(new NestedInteger(5));
        nestedList.add(l3);
        nestedList.add(new NestedInteger(4));
        nestedList.add(l3);
        itr.add(new FlattenNestedListIterator(nestedList));

        for(int i = 0; i < itr.size(); i++) {
            while (itr.get(i).hasNext()) {
                System.out.println(itr.get(i).next());
            }
        }
    }
}
