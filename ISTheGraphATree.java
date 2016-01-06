package SPOJ;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

//Traverse and keep checking if the edge encountered is a back edge. If you find n-1 edges without finding back edges.
//back edge : vertex where other end has already encountered.


public class IsTheGraphATree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		Graph graph = new Graph(nodes);
		int left[] = new int[edges];
		int right[] = new int[edges];
		for(int i=0;i<edges;i++){
			left[i] = sc.nextInt();
			right[i] = sc.nextInt();
		}
		
		for(int i=0;i<edges;i++){
			graph.addEdge(left[i], right[i]);
		}
		ConnectedComponent cc = new ConnectedComponent(graph,left[0]);
		//System.out.println(cc.isConnected());
		
		if(edges>nodes-1){
			System.out.println("NO");
		}

		else if(cc.isTree()){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}

class ConnectedComponent{
	boolean marked[];
	Graph G = null;
	int s = 0;
	
	public ConnectedComponent(Graph G,int s){
		this.G = G;
		this.s = s;
		marked = new boolean[G.V()];
 	}
	
	public boolean isTree(){
		if(hasCycle(G,s,-1)){
			return false;
		}
		
		//System.out.println(Arrays.toString(marked));
		
		for(int i=1;i<G.V();i++){
			if(!marked[i]){
					return false;
			}
		}
		return true;
	}
	
	public boolean hasCycle(Graph G,int v,int parent){
		
		marked[v] = true;
		
		for(int w : G.adj(v)){
			if(!marked[w]){
				if(hasCycle(G,w,v)){
					return true;
				}
			}
			else if(w!=parent){
				return true;
			}
		}
		return false;
	}
}

class Graph{
	Bag<Integer> [] adj;
	int V;
	public Graph(int V){
		this.V= V+1;
		adj = new Bag[this.V+1];
		for(int i=1;i<this.V;i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int u,int v){
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public Iterable<Integer> adj(int i){
		return adj[i];
	}
	public int V(){
		return this.V;
	}
}


class Bag<Item> implements Iterable<Item>{
	private Node first;
	class Node{
		Item item;
		Node next;
	}
	
	public void add(Item item){
		Node oldFirst = first;
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = oldFirst;
		first = newNode;
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	class BagIterator implements Iterator<Item>{
		Node current = first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}