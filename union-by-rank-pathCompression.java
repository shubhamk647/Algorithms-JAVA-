import java.util.*;

class Node{
	int rank;
	int data;
	Node parent;
}
class UnionByRank{
	Node node;
	HashMap<int, Node>map = new HashMap<>();
	public void makeSet(int data){
		node = new Node();
		node.rank = 0;
		node.data = data;
		node.parent = node;
		map.put(data, node);
	}

	public void unionSet(int data1, int data2){
		Node n1 = map.get(data1);
		Node n2 = map.get(data2);

		Node p1 = findSet(n1);
		Node p2 = findSet(n2);

		if(p1.rank == p2.rank){
			return;
		}
		if(p1.rank >= p2.rank){
			p1.rank = (p1.rank == p2.rank) ? p1.rank+1 : p1.rank;
			p2.parent = p1;
		}
		else{
			p1.parent = p2;
		}

	}
	public node findSet(Node n){
		Node parent = n.parent;
		if(parent == n){
			return parent;
		}
		n.parent =findSet(n.parent);
		return n.parent; 
	}
}
class Union_by_rank_pathCompression{
	public static void main(String[] args){
		UnionByRank unionByRank = new UnionByRank();
		for(int i = 1 ; i<=7; i++){
			unionByRank.makeSet(i);
		}
		unionByRank.unionSet(1,2);
		unionByRank.unionSet(2,3);
		unionByRank.unionSet(4,5);
		unionByRank.unionSet(6,7);
		unionByRank.unionSet(3,7);

		for(int i = 1 ; i<=7; i++){
			System.out.println(unionByRank.findSet(i));
		}
	}
}