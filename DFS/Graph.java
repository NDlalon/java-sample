import java.util.LinkedList;

public class Graph<T extends Comparable> {
	
	LinkedList<Node[]> graph=new LinkedList<Node[]>();
	
	public Graph() {
		
	}
	
	public Graph(Node[] nodes) {
		add(nodes);
	}
	
	public void add(Node[] nodes) {
		graph.add(nodes);
	}
	
	public Node[] getAdjNodes(Node node) {
		for(Node[] nodes:graph) {
			if(nodes[0].getKey().compareTo(node.getKey())==0) {
				return nodes;
			}
		}
		
		return null;
	}
	
	public Node[] getNode() {
		Node[] nodes =new Node[graph.size()];
		for(int i=0;i<nodes.length;i++) {
			nodes[i]=graph.get(i)[0];
		}
		return nodes;
	}
	
}
