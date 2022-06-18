import java.awt.Color;

public class DFS {
	
	private int time=0;
	
	public DFS() {
		Graph graph=generateGraph();
		computeDFS(graph);
	}
	
	public void computeDFS(Graph g) {
		for(Node node:g.getNode()) {
			node.setColor(Color.white);
			node.setParent(null);
		}
		time=0;
		for(Node u:g.getNode()) {
			if(u.getColor()==Color.white) {
				DFS_visit(g,u);
			}
		}
	}
	
	public void DFS_visit(Graph g,Node u) {
		time++;
		u.setDiscover(time);
		u.setColor(Color.gray);
		printNodes(g);
		for(Node v:g.getAdjNodes(u)) {
			if(v.getColor()==Color.white) {
				v.setParent(u);
				DFS_visit(g,v);
			}
		}
		printNodes(g);
		u.setColor(Color.black);
		time++;
		u.setFinish(time);
		printNodes(g);
	}
	
	private void printNodes(Graph g) {
		System.out.println("\n\n**********************");
		for(Node n:g.getNode()) {
			System.out.println(n.getKey()+";d="+n.getDiscover()+"\t f="+n.getFinish()+"\tcolor="+strColor(n.getColor()));
		}
	}
	
	private String strColor(Color color) {
		if(color==Color.white) {
			return "White";
		}
		else if(color==Color.gray) {
			return "Gray";
		}
		else {
			return "Black";
		}
	}
	
	public Graph<String> generateGraph(){
		Node<String> u=new Node<String>("u");
		Node<String> v=new Node<String>("v");
		Node<String> w=new Node<String>("w");
		Node<String> x=new Node<String>("x");
		Node<String> y=new Node<String>("y");
		Node<String> z=new Node<String>("z");
		Graph<String> graph=new Graph<String>();
		graph.add(new Node[] {u,v,x});
		graph.add(new Node[] {v,y});
		graph.add(new Node[] {w,y,z});
		graph.add(new Node[] {x,v});
		graph.add(new Node[] {y,x});
		graph.add(new Node[] {z,z});
		
		return graph;
	}
	
	public static void main(String[] args) {
		new DFS();
	}
}
