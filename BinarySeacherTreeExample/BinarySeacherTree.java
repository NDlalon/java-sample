package BinarySeacherTreeExample;

public class BinarySeacherTree {

	public BinarySeacherTree() {
		double[] data=new double[] {12,5,18,2,9,15,19,13,17};
		double obj=18;
		double dobj=18;
		Node root=null;
		Node SearchNode=null;
		Node DeleteNode=null;
		
		for(int i=0;i<data.length;i++) {
			root=Insertion(root,data[i]);
		}
		
		System.out.println();
		
		Treewalk(root);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Search "+obj);
		SearchNode=TreeSearch(root,obj);
		if(SearchNode==null) {
			System.out.println("SearchedNode:not find");
		}
		else {
			System.out.println(SearchNode.getValue());
		}
		
		System.out.println();
		
		System.out.println("Maximum:"+Maximum(root).getValue());
		System.out.println("Minimum:"+Minimum(root).getValue());
		
		System.out.println();
		
		DeleteNode=TreeSearch(root,dobj);
		System.out.println();
		root=TreeDelete(root,DeleteNode);
		Treewalk(root);
		System.out.println();
		
	}
	
	public Node Insertion(Node node,double value) {
		Node point=node;
		System.out.println("Insert value:"+value);
		if(node==null) {
			node=new Node(value);
		}
		else {
			while(true) {
				if(value<point.getValue()) {
					if(point.getleftNode()==null) {
						Node x =new Node(value);
						x.setparentNode(point);
						point.setleftNode(x);
						System.out.println("  Insert to the left node \tParent node:"+point.getValue());
						break;
					}
					else {
						point=point.getleftNode();
					}
				}
				else {
					if(point.getrightNode()==null) {
						Node x=new Node(value);
						x.setparentNode(point);
						point.setrightNode(x);
						System.out.println("  Insert to the right node\tParent node:"+point.getValue());
						break;
					}
					else {
						point=point.getrightNode();
					}
				}
			}
		}
		
		return node;
	}
	
	public void Treewalk(Node node) {
		if(node!=null) {
			Treewalk(node.getleftNode());
			System.out.print(node.getValue()+" -> ");
			Treewalk(node.getrightNode());
		}
	}
	
	public Node TreeSearch(Node node,double value) {
		if(node==null||node.getValue()==value) {
			return node;
		}
		else {
			if(value<node.getValue()) {
				System.out.print(node.getValue()+" -> ");
				return TreeSearch(node.getleftNode(),value);
			}
			else {
				System.out.print(node.getValue()+" -> ");
				return TreeSearch(node.getrightNode(),value);
			}
		}
	}
	
	public Node Transplant(Node d,Node r) {
		if(r!=null) {
			r.setparentNode(d.getparentNode());
		}
		if(d.getparentNode()==null) {
			d=r;
		}
		else if(d==d.getparentNode().getleftNode()) {
			d.getparentNode().setleftNode(r);
		}
		else {
			d.getparentNode().setrightNode(r);
		}
		
		while(d.getparentNode()!=null) {
			d=d.getparentNode();
		}
		
		return d;
	}
	
	public Node TreeDelete(Node node,Node delete) {
		
		if(delete!=null) {
			System.out.println("Delete:"+delete.getValue());
			if(delete.getleftNode()==null) {
				node=Transplant(delete,delete.getrightNode());
			}
			else if(delete.getrightNode()==null) {
				node=Transplant(delete,delete.getleftNode());
			}
			else {
				if(delete.getparentNode()==null) {
					delete.getleftNode().setparentNode(Minimum(delete.getrightNode()));
					Minimum(delete.getrightNode()).setleftNode(delete.getleftNode());;
					delete.getrightNode().setparentNode(null);
					node=delete.getrightNode();
				}
				else if(delete.getparentNode().getleftNode()==delete) {
					delete.getrightNode().setparentNode(delete.getparentNode());
					delete.getparentNode().setleftNode(delete.getrightNode());
					delete.getleftNode().setparentNode(Minimum(delete.getrightNode()));
					Minimum(delete.getrightNode()).setleftNode(delete.getleftNode());;
					while(delete.getparentNode()!=null) {
						delete=delete.getparentNode();
					}
					node=delete;
				}
				else {
					delete.getrightNode().setparentNode(delete.getparentNode());
					delete.getparentNode().setrightNode(delete.getrightNode());
					delete.getleftNode().setparentNode(Minimum(delete.getrightNode()));
					Minimum(delete.getrightNode()).setleftNode(delete.getleftNode());;
					while(delete.getparentNode()!=null) {
						delete=delete.getparentNode();
					}
					node=delete;
				}
			
			}
		}
		else {
			System.out.println("Delete fall\nThe entered was not found");
		}
		
		return node;
	}
	
	public Node Minimum(Node node) {
		while(node.getleftNode()!=null) {
			node=node.getleftNode();
		}
		
		return node;
	}
	
	public Node Maximum(Node node) {
		while(node.getrightNode()!=null) {
			node=node.getrightNode();
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		new BinarySeacherTree();
	}
	
}
