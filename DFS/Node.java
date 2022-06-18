import java.awt.Color;

public class Node<T extends Comparable> {
	private T key=null;
	private Color color=null;
	private int discover=0;
	private int finish=0;
	private Node parent=null;
	
	public Node() {
		
	}
	
	public Node(T key) {
		setKey(key);
	}
	
	public void setKey(T key) {
		this.key=key;
	}
	
	public T getKey() {
		return key;
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setDiscover(int discover) {
		this.discover=discover;
	}
	
	public int getDiscover() {
		return discover;
	}
	
	public void setFinish(int finish) {
		this.finish=finish;
	}
	
	public int getFinish() {
		return finish;
	}
	
	public void setParent(Node parent) {
		this.parent=parent;
	}
	
	public Node getParent() {
		return parent;
	}
}
