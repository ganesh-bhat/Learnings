package com.algorithms.trees;

public interface BinaryTree<U> {

    public interface BinaryTreeNode<T> {
        void setRight(BinaryTreeNode<T> node);
        void setLeft(BinaryTreeNode<T> node);
        BinaryTreeNode<T> getRight();
        BinaryTreeNode<T> getLeft();
        T getData();
        void setData(T data);
        BinaryTreeNode<T> getParent();
        void removeFromParent();


    }

    /**
     * Return the values via constructor param of Traversal algorith.
     * Use the java Consumer interface
     */
    public interface TraversalAlgorithm<T> {

        public void traverse(BinaryTree<T> tree);

    }

    public void traverse(TraversalAlgorithm algorithm);

    public BinaryTreeNode<U> getRoot();

}
