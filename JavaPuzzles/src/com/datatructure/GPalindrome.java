package com.datatructure;

import java.util.Iterator;

public class GPalindrome<T> {

    public void isPalindrome(GLinkedList<T> list) {
        GLinkedList<T> reverse = getReverse(list);

        Iterator<T> it1 = list.iterator();
        Iterator<T> it2 = reverse.iterator();
        while(it1.hasNext() && it2.hasNext()) {

        }

    }

    private GLinkedList<T> getReverse(GLinkedList<T> list) {
        Iterator<T> itt = list.iterator();
        GLinkedList<T> reverseList = new GLinkedList<>();
        if(itt.hasNext()) {
            T data = itt.next();
            reverseList.insertAtStart(data);
        }
        return reverseList;
    }
}
