package com.datatructure.tree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class GNAryTree<T> {



    private GNAryTree(Node<T> root) {
        this.root = root;
    }

    public void traverseDfs(Consumer<T> consumer) {
        Set<Node<T>> visited = new HashSet<>();
        dfs(root, visited, consumer);
    }

    private void dfs(Node<T> node, Set<Node<T>>  visited, Consumer<T> consumer) {
        if(node == null) {
            return;
        }

        //visit
        consumer.accept(node.data);
        visited.add(node);

        if(node.nodes!=null) {
            for(Node e: node.nodes) {
                if(!visited.contains(e)) {
                    dfs(e, visited,consumer);
                }
            }
        }
    }


    public static class TreeBuilder<T> {

        Node<T> root;

        public TreeBuilder addNode(T data) {
            if(root == null) {
                root = new Node(data);
            } else {
                if(root.nodes ==null) {
                    root.nodes = new HashSet<>();
                }
                root.nodes.add(new Node(data));
            }
            return this;
        }

        public TreeBuilder addNode(GNAryTree<T> tree) {
            if(root.nodes ==null) {
                root.nodes = new HashSet<>();
            }
            root.nodes.add(tree.root);
            return this;
        }

        public GNAryTree<T> toTree() {
            return new GNAryTree<>(root);
        }
    }

    private static class Node<T> {
        private T data;
        private Set<Node<T>> nodes;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(nodes, node.nodes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, nodes);
        }
    }

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }



}
