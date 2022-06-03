package o_o;

import java.awt.Color;

public class Node <T extends Comparable> {
	
	public Node parentNode=null;
	public Node leftNode=null;
	public Node rightNode=null;
	
	private T key;
	private Color color=null;
	
	public Node() {
		
	}
	
	public Node(T key) {
		setKey(key);
		setColor(Color.red);
	}
	
	public void setKey(T key) {
		this.key=key;
	}
	
	public T getkey() {
		return key;
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String toString() {
		String NodeInfo="";
		NodeInfo=NodeInfo+"Key="+key+"("+(color==Color.red?"red) ":"black),");
		if(parentNode==null) {
			NodeInfo=NodeInfo+"parentNode=null,";
		}
		else {
			NodeInfo=NodeInfo+"ParentNode:key="+parentNode.getkey()+"("+(parentNode.getColor()==Color.red?"red),":"black),");
		}
		if(leftNode==null) {
			NodeInfo=NodeInfo+"leftNode=null,";
		}
		else {
			NodeInfo=NodeInfo+"leftNode:key="+leftNode.getkey()+"("+(leftNode.getColor()==Color.red?"red),":"black),");
		}
		if(rightNode==null) {
			NodeInfo=NodeInfo+"rightNode=null";
		}
		else {
			NodeInfo=NodeInfo+"rightNode:key="+rightNode.getkey()+"("+(rightNode.getColor()==Color.red?"red)":"black)");
		}
		
		
		return NodeInfo;
	}
	
}
