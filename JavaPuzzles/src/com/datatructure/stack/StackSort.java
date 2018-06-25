package com.datatructure.stack;

public class StackSort {

    ArrayStack<Integer> s1 = new ArrayStack<>();
    ArrayStack<Integer> s2 = new ArrayStack<>();

    void sort(int[] numbers) {

        for(int num: numbers) {
            s1.push(num);
        }

        while(!s1.isEmpty()) {
            int temp = s1.pop();

            while(!s2.isEmpty() && s2.peek() < temp) {
                int elem = s2.pop();
                s1.push(elem);
            }
            s2.push(temp);
        }

        int i = 0;
        while(!s2.isEmpty()) {
            numbers[i++] = s2.pop();
        }
    }
}
