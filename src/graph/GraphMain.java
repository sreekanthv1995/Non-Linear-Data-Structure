package graph;

public class GraphMain {

    public static void main(String[] args) {

        Graph myGraph = new Graph();
        System.out.println(myGraph.addVertex("A"));
        System.out.println(myGraph.addVertex("B"));
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        System.out.println(myGraph.addEdge("A","B"));
        myGraph.addEdge("A","C");
        myGraph.addEdge("A","D");
        myGraph.addEdge("B","D");
        myGraph.addEdge("C","D");
        System.out.println(myGraph.removeVertex("D"));


        myGraph.printGraph();
    }
}
