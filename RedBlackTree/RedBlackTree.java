package o_o;

import java.awt.Color;

public class RedBlackTree {
	
	public Node root=null;
	
	public RedBlackTree() {
		double[] data=new double[] {11,2,14,1,7,15,5,8,4};
		Node searchNode =new Node(5.0);
		
		for(double d:data) {
			Node z=new Node(d);
			root=Insert(root,z);
			InsertFixup(z);
			Treewalk();
			System.out.println();
		}
		
		Node findNode=search(root,searchNode);
		if(findNode==null) {
			System.out.println("Search Node not fit");
		}
		else {
			System.out.println("Search Node:"+findNode.toString());
		}
		
		if(findNode!=null) {
			System.out.println("Delete:"+findNode.getkey());
			Delete(findNode);
			Treewalk();
		}
		else {
			System.out.println("Can not delete");
		}
	}
	
	public void Treewalk() {
		if(root!=null) {
			Treewalk(root);
		}
	}
	
	public void Treewalk(Node node) {
		if(node.leftNode!=null) {
			Treewalk(node.leftNode);
		}
		System.out.println(node.toString());
		if(node.rightNode!=null) {
			Treewalk(node.rightNode);
		}
	}
	
	public void leftRotate(Node x) {
		Node y=x.rightNode;
		
		y.parentNode=x.parentNode;
		if(x.parentNode==null) {
			root=y;
		}
		else if(x.parentNode.leftNode==x) {
			x.parentNode.leftNode=y;
		}
		else {
			x.parentNode.rightNode=y;
		}
		x.rightNode=y.leftNode;
		if(y.leftNode!=null) {
			y.leftNode.parentNode=x;
		}
		y.leftNode=x;
		x.parentNode=y;
	}
	
	public void rightRotate(Node x) {
		Node y=x.leftNode;
		
		y.parentNode=x.parentNode;
		if(x.parentNode==null) {
			root=y;
		}
		else if(x.parentNode.leftNode==x) {
			x.parentNode.leftNode=y;
		}
		else {
			x.parentNode.rightNode=y;
		}
		x.leftNode=y.rightNode;
		if(y.rightNode!=null) {
			y.rightNode.parentNode=x;
		}
		y.rightNode=x;
		x.parentNode=y;
	}
	
	public Node Insert(Node root,Node z) {
		if(root==null) {
			return z;
		}
		if(root.getkey().compareTo(z.getkey())>=0) {
			root.leftNode=Insert(root.leftNode,z);
			root.leftNode.parentNode=root;
		}
		else {
			root.rightNode=Insert(root.rightNode,z);
			root.rightNode.parentNode=root;
		}
		
		return root;
	}
	
	public void InsertFixup(Node z) {
		while(z!=root && z.parentNode.getColor()==Color.red) {
			Node parent=z.parentNode;
			Node grandparent=z.parentNode.parentNode;
			Node uncle=null;
			
			if(parent.parentNode.leftNode==parent) {
				uncle=grandparent.rightNode;
				if(uncle!=null&&uncle.getColor()==Color.red) {
					parent.setColor(Color.black);
					uncle.setColor(Color.black);
					grandparent.setColor(Color.red);
					z=grandparent;
				}
				else {
					if(z==parent.rightNode) {
						leftRotate(parent);
						parent=z;
						z=grandparent;
					}
					parent.setColor(Color.black);
					grandparent.setColor(Color.red);
					rightRotate(grandparent);
				}
			}
			else{
				uncle=grandparent.leftNode;
				if(uncle!=null&&uncle.getColor()==Color.red) {
					parent.setColor(Color.black);
					uncle.setColor(Color.black);
					grandparent.setColor(Color.red);
					z=grandparent;
				}
				else {
					if(z==parent.leftNode) {
						rightRotate(parent);
						parent=z;
						z=grandparent;
					}
					parent.setColor(Color.black);
					grandparent.setColor(Color.red);
					leftRotate(grandparent);
				}
			}
		}
		root.setColor(Color.black);
	}
	
	public Node search(Node T,Node k) {
		if(T==null||k.getkey().compareTo(T.getkey())==0) {
			return T;
		}
		if(k.getkey().compareTo(T.getkey())<0) {
			return search(T.leftNode,k);
		}
		else {
			return search(T.rightNode,k);
		}
	}
	
	public Node minimum(Node T) {
		if(T.leftNode==null) {
			return T;
		}
		return minimum(T.leftNode);
	}
	
	public Node maxmum(Node T) {
		if(T.rightNode==null) {
			return T;
		}
		return maxmum(T.rightNode);
	}
	
	public void Transplant(Node u,Node v) {
		if(u.parentNode==null) {
			root=v;
		}
		else if(u.parentNode.leftNode==u) {
			u.parentNode.leftNode=v;
		}
		else {
			u.parentNode.rightNode=v;
		}
		if(v!=null) {
			v.parentNode=u.parentNode;
		}
	}
	
	public void Delete(Node d) {
		Node y=d;
		Node x=null;
		Node x_parent=null;
		Color y_originColor=y.getColor();
		
		if(d.leftNode==null) {
			x=d.rightNode;
			x_parent=d.parentNode;
			Transplant(d, d.rightNode);
			if(x_parent==null) {
				root=x;
			}
		}
		else if(d.rightNode==null) {
			x=d.leftNode;
			x_parent=d.parentNode;
			Transplant(d, d.leftNode);
			if(x_parent==null) {
				root=x;
			}
		}
		else {
			y=minimum(d.rightNode);
			y_originColor=y.getColor();
			if(y.parentNode==d) {
				x_parent=y;
				if(x!=null) {
					x.parentNode=y;
				}
			}
			else {
				x_parent=y.parentNode;
				Transplant(y,y.rightNode);
				y.rightNode=d.rightNode;
				y.rightNode.parentNode=y;
			}
			Transplant(d, y);
			y.leftNode=d.leftNode;
			y.leftNode.parentNode=y;
			y.setColor(d.getColor());
			
			if(y.parentNode==null) {
				root=y;
			}
		}
		if(y_originColor==Color.black&&x!=null) {
			DeleteFixup(x,x_parent);
		}
	}
	
	public void DeleteFixup(Node x,Node x_parent) {
		while(x!=root && x.getColor()==Color.black) {
			Node w=null;
			if(x==x_parent.leftNode) {
				w=x_parent.rightNode;
				if(w!=null &&w.getColor()==Color.red) {
					w.setColor(Color.black);
					x_parent.setColor(Color.red);
					leftRotate(x_parent);
					w=x_parent.rightNode;
				}
				if((w.leftNode==null||w.leftNode.getColor()==Color.black)&&(w.rightNode==null||w.rightNode.getColor()==Color.black)) {
					w.setColor(Color.red);
					x=x.parentNode;
					x_parent=x.parentNode;
				}
				else {
					if(w.rightNode==null||w.rightNode.getColor()==Color.black) {
						w.leftNode.setColor(Color.black);
						w.setColor(Color.red);
						rightRotate(w);
						w=x_parent.rightNode;
					}
					w.setColor(x_parent.getColor());
					x_parent.setColor(Color.black);
					w.rightNode.setColor(Color.black);
					leftRotate(x_parent);
					x=root;
				}
			}
			else {
				w=x_parent.leftNode;
				if(w!=null &&w.getColor()==Color.red) {
					w.setColor(Color.black);
					x_parent.setColor(Color.red);
					rightRotate(x_parent);
					w=x_parent.leftNode;
				}
				if((w.leftNode==null||w.leftNode.getColor()==Color.black)&&(w.rightNode==null||w.rightNode.getColor()==Color.black)) {
					w.setColor(Color.red);
					x=x.parentNode;
					x_parent=x.parentNode;
				}
				else {
					if(w.leftNode==null||w.leftNode.getColor()==Color.black) {
						w.rightNode.setColor(Color.black);
						w.setColor(Color.red);
						leftRotate(w);
						w=x_parent.rightNode;
					}
					w.setColor(x_parent.getColor());
					x_parent.setColor(Color.black);
					w.leftNode.setColor(Color.black);
					rightRotate(x_parent);
					x=root;
				}
			}
		}
		x.setColor(Color.black);
	}
	
	public static void main(String args[]) {
		new RedBlackTree();
	}
}
