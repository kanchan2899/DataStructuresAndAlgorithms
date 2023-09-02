package com.dsalgo.stacks;

import java.util.Stack;

/**
 * Approach: Define a variable minEle that stores the current minimum element in the stack.
 * Now the interesting part is, how to handle the case when the minimum element is removed.
 * To handle this, we push “2x – minEle” into the stack instead of x so that the previous minimum
 * element can be retrieved using the current minEle and its value stored in the stack.
 *
 * Push(x): Insert x at the top of the stack
 *
 * 1. If the stack is empty, insert x into the stack and make minEle equal to x.
 * 2. If the stack is not empty, compare x with minEle. Two cases arise:
 * 3. If x is greater than or equal to minEle, simply insert x.
 * 4. If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x.
 * 5. For example, let the previous minEle be 3. Now we want to insert 2. We update minEle as 2 and insert 2*2 – 3 = 1 into the stack
 *
 *
 * Pop(): Removes an element from the top of the stack
 *
 * 1. Remove the element from the top. Let the removed element be y. Two cases arise:
 * 2. If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
 * 3. If y is less than minEle, the minimum element now becomes (2*minEle – y), so update (minEle = 2*minEle – y). This is where we retrieve the previous minimum from the current minimum and its value in the stack.
 * 4. For example, let the element to be removed be 1 and minEle be 2. We remove 1 and update minEle as 2*2 – 1 = 3
 *
 * NOTE: Stack doesn’t hold the actual value of an element if it is minimum so far.
 *       The actual minimum element is always stored in the minEle variable
 *
 *
 * How does this approach work?
 *
 * When the element to be inserted is less than minEle, we insert “2x – minEle”. The important
 * thing to note is, that 2x – minEle will always be less than x (proved below), i.e., new minEle
 * and while popping out this element we will see that something unusual has happened as the popped
 * element is less than the minEle. So we will be updating minEle.
 */
public class GetMinimum {
    static Stack<Integer> stack;
    Integer minElement;

    GetMinimum() {
        stack = new Stack<>();
    }

    void getMin() {
        // get the minimum number in the entire stack
        if(stack.isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Minimum element in the stack is " + minElement);
    }

    void peek() {
        if(stack.isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }

        // top element
        Integer t = stack.peek();

        // if t < minElement means minElement stores value of t
        if(t < minElement) {
            System.out.println("Topmost element is " + minElement);
        } else {
            System.out.println("Topmost element is " + t);
        }
    }

    // removes the top element from the stack
    void pop() {
        if(stack.isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }

        System.out.print("Topmost element removed ");
        Integer t = stack.pop();

        // minimum will change as the minimum element of the stack is being removed
        if(t < minElement) {
            System.out.println(minElement);
            minElement = 2 * minElement - t;
        } else {
            System.out.println(t);
        }
    }

    void push(Integer x) {
        if(stack.isEmpty()) {
            minElement = x;
            stack.push(x);
            System.out.println("Number inserted is " + x);
            return;
        }

        if(x < minElement) {
            stack.push(2 * x - minElement);
            minElement = x;
        } else {
            stack.push(x);
        }
        System.out.println("Number inserted is " + x);
    }

    public static void main(String[] args) {
        GetMinimum getMinimumStack = new GetMinimum();

        getMinimumStack.push(3);
        getMinimumStack.push(5);
        getMinimumStack.getMin();
        getMinimumStack.push(9);
        getMinimumStack.push(1);
        getMinimumStack.getMin();
        getMinimumStack.pop();
        getMinimumStack.getMin();

    }
}
