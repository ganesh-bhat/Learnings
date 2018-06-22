package com.learning.algorithms.graphs;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by ganes on 09-06-2018.
 *
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
public class GraphAlgorithms {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.add(0,1);
        graph.add(1, 2);
        graph.add(2, 0);
        graph.add(2, 2);
        graph.add(2, 3);

        graph.performBfs(new Consumer<Integer>() {
            @Override
            public void accept(Integer elem) {
                System.out.println("Visiting:"+elem);
            }
        });

        Graph<String> graph2 = new Graph<>();
        graph2.add("A","B");
        graph2.add("B","A");
        graph2.add("A", "C");
        graph2.add("C", "A");
        graph2.add("B", "D");
        graph2.add("D", "E");
        graph2.add("E", "D");
        graph2.add("C", "E");
        graph2.add("E", "C");
        graph2.add("E", "F");
        graph2.add("D", "F");

        graph2.performBfs( new Consumer<String>() {
            @Override
            public void accept(String elem) {
                System.out.println("Visiting:"+elem);
            }
        });
        System.out.println("--------- DFS -----------");

        graph2.performDfs(graph2.getFirstNode(), new HashSet<>(), new Consumer<String>() {
            @Override
            public void accept(String elem) {
                System.out.println("Visiting:" + elem);
            }
        });

    }

    static class Graph<T extends Comparable> implements Iterable<Map.Entry<T, List<T>>>{
        Map<T, List<T>> adjacency = new HashMap<>();

        private void add(T u, T v) {
            if(adjacency.containsKey(u)) {
                adjacency.get(u).add(v);
            } else {
                List<T> list = new LinkedList<>();
                list.add(v);
                adjacency.put(u, list);
            }
        }

        private List<T> getAdjacentNodes(T u) {
            if(adjacency.containsKey(u)) {
                return adjacency.get(u);
            }
            return null;
        }

        public Iterator<Map.Entry<T, List<T>>> iterator() {
            return adjacency.entrySet().iterator();
        }

        public T getFirstNode() {
            return adjacency.keySet().iterator().next();
        }

        public void performBfs(Consumer<T> consumer) {
            Set<T> visited = new HashSet<>();
            T firstNode = getFirstNode();
            Queue<T> queue = new LinkedList<>();
            queue.add(firstNode);

            while(!queue.isEmpty()) {
                T elem = queue.poll();
                if(visited.add(elem)) {
                    consumer.accept(elem);
                }
                List<T> adjs = getAdjacentNodes(elem);
                if(adjs!=null) {
                    for(T node: adjs) {
                        if(!visited.contains(node)) {
                            queue.add(node);
                        }
                    }
                }

            }
        }

        public void performDfs( T firstNode, Set<T> visited, Consumer<T> consumer) {
            consumer.accept(firstNode);
            visited.add(firstNode);
            List<T> adjs = getAdjacentNodes(firstNode);
            if(adjs!=null) {
                for(T node: adjs) {
                    if(!visited.contains(node)) {
                        performDfs(node, visited, consumer);
                    }
                }
            }

        }
    }


}
