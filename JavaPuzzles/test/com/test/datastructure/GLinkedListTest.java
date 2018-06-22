package com.test.datastructure;

import com.datatructure.GLinkedList;
import org.junit.Test;

import java.util.Arrays;

public class GLinkedListTest {

    @Test
    public void testWaveList() {
        GLinkedList<String> list = new GLinkedList<>();
        list.insertAtEnd("a1");
        list.insertAtEnd("a2");
        list.insertAtEnd("a3");
        list.insertAtEnd("a4");
        list.insertAtEnd("a5");
        list.insertAtEnd("b1");
        list.insertAtEnd("b2");
        list.insertAtEnd("b3");
        list.insertAtEnd("b4");
        list.insertAtEnd("b5");

        System.out.println(list);
        list.weaveList();
        System.out.println(list);
    }

    public static void testGetListKElem() {
        GLinkedList<String> list = new GLinkedList<>();
        list.insertAtEnd("a1");
        list.insertAtEnd("a2");
        list.insertAtEnd("a3");
        list.insertAtEnd("a4");
        list.insertAtEnd("a5");
        list.insertAtEnd("b1");
        list.insertAtEnd("b2");
        list.insertAtEnd("b3");
        list.insertAtEnd("b4");
        list.insertAtEnd("b5");
        System.out.println(Arrays.toString(list.getLastElements(5)));
    }


}
