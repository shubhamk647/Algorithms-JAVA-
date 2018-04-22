import java.util.*;
class Graph{

	int vertex;
	LinkedList<Integer>list[];
	Graph(int vertex){
		this.vertex = vertex;
		list = new LinkedList[vertex];

		for(int i = 0; i < vertex; i++){
			list[i] = new LinkedList();
		}
	}

	public void addEdge(int u, int v){
		list[u].add(v);
	}

	public void topologicalSort(){
		Stack<Integer> stack = new Stack();
		boolean[] visited = new boolean[vertex];

		for(int i = 0; i < vertex; i++){
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		while (stack.empty()==false)
            System.out.print(stack.pop() + " ");

	}
	public void topologicalSortUtil(int v, boolean[] visited, Stack stack ){
		visited[v] = true;
		Iterator<Integer> it = list[v].iterator();
		while(it.hasNext()){
			int i = it.next();
			if(!visited[i]){
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(v);
	}

}
 
public class TopologicalSort{
	public static void main(String[] args) {
		
		Graph g= new Graph(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topologicalSort();


	}


}