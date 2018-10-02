package com.common.java;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * explores interesting set operations which implements SortedSet and NavigableSet
 */
public class InterestingSetOperations {

    public static void main(String[] args) {

        SortedSet<String> dictionary = new TreeSet<>();

        dictionary.add("apple");
        dictionary.add("adam");
        dictionary.add("ape");
        dictionary.add("aerospace");
        dictionary.add("bat");
        dictionary.add("ball");
        dictionary.add("bullet");
        dictionary.add("cat");
        dictionary.add("camel");
        dictionary.add("car");
        dictionary.add("dog");
        dictionary.add("door");
        dictionary.add("dots");
        dictionary.add("elephant");

        //get elements starting from b-d, excluding e
        SortedSet<String> result = dictionary.subSet("b", "e");
        System.out.println(result);

        //start to e, excluding e
        result = dictionary.headSet("e");
        System.out.println(result);

        //from end, till d, including d
        result = dictionary.tailSet("d");
        System.out.println(result);


        System.out.println(((NavigableSet<String>) dictionary).ceiling("ca"));
        System.out.println(((NavigableSet<String>) dictionary).floor("do"));

        System.out.println("-- polling dictionary from start --");
        System.out.println(((NavigableSet<String>) dictionary).pollFirst());
        System.out.println(((NavigableSet<String>) dictionary).pollFirst());
        System.out.println(((NavigableSet<String>) dictionary).pollFirst());
        System.out.println(((NavigableSet<String>) dictionary).pollFirst());


    }

}
