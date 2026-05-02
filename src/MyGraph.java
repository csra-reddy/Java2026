import java.util.*;

public class MyGraph {

    Map<Integer,List<Integer>> adjList;

    MyGraph(int v) {
        adjList = new HashMap<>(v);
        for(int i = 0; i < v; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    List<Integer> getConnectedNodes(int v) {
        return adjList.get(v);
    }

    void bfs(int start) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println(currentNode + " ");
            for(int i : adjList.get(currentNode)) {
                if(!visited.contains(i)) {
                    visited.add(i);
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);

        System.out.println("0" + "-->" +graph.getConnectedNodes(0));
        System.out.println("1" + "-->" +graph.getConnectedNodes(1));
        System.out.println("2" + "-->" +graph.getConnectedNodes(2));
        System.out.println("3" + "-->" +graph.getConnectedNodes(3));
        System.out.println("4" + "-->" +graph.getConnectedNodes(4));
        graph.bfs(0);
    }
}
