import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<Integer> getAdjList(int v) {
        return adjList.get(v);
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        System.out.println("0" + "-->" +graph.getAdjList(0));
        System.out.println("1" + "-->" +graph.getAdjList(1));
        System.out.println("2" + "-->" +graph.getAdjList(2));
        System.out.println("3" + "-->" +graph.getAdjList(3));
    }
}
