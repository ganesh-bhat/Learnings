package com.datatructure.tree;

import java.util.HashMap;
import java.util.Map;

public class GTrie {

    public SpellChecker spellChecker() {
        return new SpellChecker();
    }

    public class SpellChecker {
        Node parent = root;

        public boolean check(char c) {
            if(parent.children.containsKey(c)) {
                parent = parent.children.get(c);
                return true;
            }
            return false;
        }

        public boolean done() {
            return parent.isComplete;
        }


        public void reset() {
            parent = root;
        }
    }

    class Node {
        Map<Character,Node> children;
        boolean isComplete;

        Node(boolean isCompeleteWord) {
            this.isComplete = isCompeleteWord;
        }

    }

    Node root = new Node(false);

    public void addWord(String word) {
        Node prev = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(i == word.length()-1) {//last char
                addNode(c, prev, true);
            } else {
                prev = addNode(c, prev, false);
            }
        }
    }

    private Node addNode(char c, Node prev, boolean isWordComplete) {
            Node parent = prev;
            Node node = null;

            if(parent.children == null) {
                parent.children = new HashMap<>();
            }

            if(parent.children.containsKey(c)) {
                node = parent.children.get(c);
                node.isComplete = node.isComplete||isWordComplete;
            } else {
                node = new Node(isWordComplete);
                parent.children.put(c,node);
            }
            return node;
    }

    public void printAllWords() {
        System.out.println("Printing all words in Trie");
        printWord(root,"");
        System.out.println("-----------------------------------------");
    }

    private void printWord(Node node,String sb) {
        if(node!=null) {
            if(node.children!=null) {
                for(Map.Entry<Character,Node> child: node.children.entrySet()) {
                    sb = sb+(child.getKey());
                    if(child.getValue().isComplete) {
                        System.out.println(sb);
                    }
                    printWord(child.getValue(),sb);
                }
            }
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
