package com.generic;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;




public class GraphClient {
    public static void main(String[] args){
        Graph<String> graph = new Graph(6,false);
        graph.addEdge("A","B",1);
        graph.addEdge("A","C",1);
        graph.addEdge("B","D",1);
        graph.addEdge("B","E",1);
        graph.addEdge("C","E",1);
        graph.addEdge("D","F",1);
        graph.addEdge("E","F",1);

        List<String> result = graph.dfs("A");
        System.out.println(result);

    }

    /**
     Represents a graph and provide traversal mechanisms
     */
    static class Graph<K>{
        static class Edge<K> {
            K node;
            int weight;

            Edge(K node, int weight) {
                this.node = node;
                this.weight = weight;
            }
            public boolean equals(Object o) {
                if(o == null) return false;
                if(this == o) return true;

                if(o instanceof Edge) {
                    Edge edge = (Edge)o;
                    if(this.node.equals(edge.node) &&
                            this.weight == edge.weight) {
                        return true;
                    }

                }
                return false;
            }

            public int hashCode(){
                return Objects.hashCode(this);
            }

            public K getNode() {
                return node;
            }
        }


        private Map<K, List<Edge<K>>> adj ;
        private boolean isDirected = true;
        public Graph(int n, boolean isDirected) {
            adj = new HashMap<K, List<Edge<K>>>(n);
            this.isDirected = isDirected;
        }

        public void addEdge(K u, K v, int weight) {
            add(u,v,weight);
            if(!isDirected) {
                add(v,u,weight);
            }
        }

        private void add(K u, K v, int weight) {
            if(adj.containsKey(u)){
                List<Edge<K>> edges = adj.get(u);
                edges.add(new Edge(v,weight));
            } else {
                List<Edge<K>> edges= new LinkedList<Edge<K>>();
                edges.add(new Edge(v,weight));
                adj.put(u, edges);
            }
        }




        public void removeEdge(K u, K v) {
            remove(u,v);
            if(!isDirected) {
                remove(v,u);
            }

        }

        private void remove(K u, K v) {
            if(adj.containsKey(u)){
                List<Edge<K>> edges = adj.get(u);
                for(Iterator<Edge<K>> itt = edges.iterator(); itt.hasNext();) {
                    Edge edge = itt.next();
                    if(edge.getNode().equals(v)){
                        itt.remove();
                    }
                }
            }
        }


        public List<K> dfs(K startNode) {

            if(startNode == null || !adj.containsKey(startNode)) {
                return null;
            }
            Set<K> visited = new HashSet<K>();
            List<K> trail = new ArrayList<K>();
            dfs(startNode, visited, trail);

            return trail;
        }

        private void dfs(K startNode, Set<K> visited, List<K> trail) {

            trail.add(startNode);
            visited.add(startNode);

            if(adj.containsKey((startNode))) {
                List<Edge<K>> edges = adj.get(startNode);
                for(Edge<K> edge:edges){
                    if(!visited.contains(edge.getNode())){
                        dfs(edge.getNode(), visited, trail);
                    }
                }
            }

        }

    }

}

