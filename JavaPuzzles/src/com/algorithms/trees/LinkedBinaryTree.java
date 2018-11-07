package com.algorithms.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by ganes on 09-06-2018.
 */
public class LinkedBinaryTree<T> implements BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public void setRoot(BinaryTreeNode node) {
        this.root = node;
    }

    @Override
    public void traverse(TraversalAlgorithm algorithm) {
        algorithm.traverse(this);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    private static class Node<T> implements BinaryTreeNode<T> {
        private T value;
        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;
        private BinaryTreeNode<T> parent;
        private Node(T value) {
            this.value = value;
        }

       @Override
       public void setRight(BinaryTreeNode<T> node) {
           this.right = node;
           ((Node)node).parent = this;
       }

       @Override
       public void setLeft(BinaryTreeNode<T> node) {
            this.left = node;
           ((Node)node).parent = this;
       }

        @Override
        public BinaryTreeNode<T> getRight() {
            return right;
        }

        @Override
        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        @Override
       public T getData() {
           return value;
       }

       @Override
       public void setData(T data) {
            this.value = data;
       }

        @Override
        public BinaryTreeNode<T> getParent() {
            return parent;
        }

        @Override
        public void removeFromParent() {
            if(parent.getLeft() == this) parent.setLeft(null);
            if(parent.getRight() == this) parent.setRight(null);
        }
    }


    public static class MinDepthFinderTraversal implements TraversalAlgorithm {

        Consumer<Integer> consumer;

        /**
         * Consumer receives callback on the depth
         * @param consumer
         */
        public MinDepthFinderTraversal(Consumer<Integer> consumer) {
            this.consumer = consumer;
        }

        @Override
        public void traverse(BinaryTree tree) {
            int depth = minDepth(tree.getRoot());
            consumer.accept(depth);
        }

        private static int minDepth(BinaryTreeNode node) {
            if(node == null) {
                return 0;
            }

            if(node.getLeft() == null && node.getRight() == null) {
                return 1;
            }
            if(node.getLeft() == null) {
                return 1 + minDepth(node);
            }

            if(node.getRight() == null) {
                return 1 + minDepth(node.getLeft());
            }

            return Math.min(minDepth(node.getLeft()),minDepth(node.getRight())) + 1;
        }
    }

    public static class BredthFirstSearchTraversal<T> implements TraversalAlgorithm<T> {

        private Consumer<T> visitor;
        private Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
        private Set<BinaryTreeNode> visited = new HashSet<>();

        /**
         * Visiter gets called for each node
         * @param visitor
         */
        public BredthFirstSearchTraversal(Consumer<T> visitor) {
            this.visitor = visitor;
        }

        @Override
        public void traverse(BinaryTree<T> tree) {
            queue.clear();
            visited.clear();
            bfs(tree.getRoot());
        }

        private void bfs(BinaryTreeNode<T> node) {
            if(queue.isEmpty() && node == null) return;
            if(queue.isEmpty() && node!=null) {
                queue.add(node);
            }

            while(!queue.isEmpty()) {
                BinaryTreeNode<T> child = queue.poll();
                if(!isVisited(child)) {
                    visitor.accept(child.getData());
                    markVisited(child);
                    BinaryTreeNode<T> leftNode = child.getLeft();
                    BinaryTreeNode<T> rightNode = child.getRight();
                    queue.offer(leftNode);
                    queue.offer(rightNode);
                }
            }
        }

        private void markVisited(BinaryTreeNode<T> child) {
            visited.add(child);
        }

        private boolean isVisited(BinaryTreeNode child) {
            return visited.contains(child);
        }

    }


    public static class InOrderTraversal<T> implements TraversalAlgorithm<T> {

        private Consumer<T> visitor;
        /**
         * Visiter gets called for each node
         * @param visitor
         */
        public InOrderTraversal(Consumer<T> visitor) {
            this.visitor = visitor;
        }

        @Override
        public void traverse(BinaryTree<T> tree) {
            dfsInorder(tree.getRoot());
        }

        private void dfsInorder(BinaryTreeNode<T> node) {
            if(node == null) return;
            dfsInorder(node.getLeft());
            visitor.accept(node.getData());
            dfsInorder(node.getRight());
        }
    }

    public static class PreOrderTraversal<T> implements TraversalAlgorithm<T> {

        private Consumer<T> visitor;

        /**
         * Visiter gets called for each node
         * @param visitor
         */
        public PreOrderTraversal(Consumer<T> visitor) {
            this.visitor = visitor;
        }

        @Override
        public void traverse(BinaryTree<T> tree) {
            dfsPreorder(tree.getRoot());
        }

        private void dfsPreorder(BinaryTreeNode<T> node) {
            if(node == null) return;
            visitor.accept(node.getData());
            dfsPreorder(node.getLeft());
            dfsPreorder(node.getRight());
        }
    }

    public static class PostOrderTraversal<T> implements TraversalAlgorithm<T> {

        private Consumer<T> visitor;

        /**
         * Visiter gets called for each node
         * @param visitor
         */
        public PostOrderTraversal(Consumer<T> visitor) {
            this.visitor = visitor;
        }

        @Override
        public void traverse(BinaryTree<T> tree) {
            dfsPostorder(tree.getRoot());
        }

        private void dfsPostorder(BinaryTreeNode<T> node) {
            if(node == null) return;
            dfsPostorder(node.getLeft());
            dfsPostorder(node.getRight());
            visitor.accept(node.getData());
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();
        tree.setRoot(new Node<Integer>(8));
        tree.getRoot().setLeft(new Node<Integer>(6));
        tree.getRoot().setRight(new Node<Integer>(9));
        tree.getRoot().getLeft().setLeft(new Node<Integer>(4));
        tree.getRoot().getRight().setLeft(new Node<Integer>(3));
        tree.getRoot().getRight().setRight(new Node<Integer>(11));

    }



}
