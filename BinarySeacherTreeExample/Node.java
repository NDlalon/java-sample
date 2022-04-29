package BinarySeacherTreeExample;

public class Node {
	
	private Node parentNode=null;
	private Node leftNode=null;
	private Node rightNode=null;
	
	private double value=0.0;
	
	public Node(double value) {
		this.value=value;
	}
	
	public void setValue(double value) {
		this.value=value;
	}
	
	public void setparentNode(Node node) {
		parentNode=node;
	}
	
	public void setleftNode(Node node) {
		leftNode=node;
	}
	
	public void setrightNode(Node node) {
		rightNode=node;
	}
	
	public Node getparentNode() {
		return parentNode;
	}
	
	public Node getleftNode() {
		return leftNode;
	}
	
	public Node getrightNode() {
		return rightNode;
	}
	
	public double getValue() {
		return value;
	}
	
	public boolean ifNIL() {
		if(leftNode!=null || rightNode!=null) {
			return false;
		}
		else {
			return true;
		}
	}
}
