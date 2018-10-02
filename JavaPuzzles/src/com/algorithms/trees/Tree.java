package com.algorithms.trees;

import java.util.Iterator;

public interface Tree<T> extends Graph<T> {

    TreeNode newNode(T data);



    public class TreeIterator<V> implements Iterator<V> {

        protected Tree<V> tree;
        protected TreeNode<V> current;

        public TreeIterator(Tree<V> tree) {
            this.tree = tree;
        }

        @Override
        public boolean hasNext() {
            if(tree!=null && current!=null) {
                return current.hasChildren();
            } else {
                return false;
            }
        }

        @Override
        public V next() {
            if(current!=null) {
                return current.getData();
            } else {
                return null;
            }

        }
    }


}
