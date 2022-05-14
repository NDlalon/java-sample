
public class NodeForCustomerInformation <T extends CustomerInformation> {
	public T CustomerInformation=null;
	private NodeForCustomerInformation parentNode=null;
	private NodeForCustomerInformation leftNode=null;
	private NodeForCustomerInformation rightNode=null;
	
	
	public NodeForCustomerInformation(T CustomerInformation) {
		setKey(CustomerInformation);
	}
	
	public void setKey(T Key) {
		this.CustomerInformation=Key;
	}
	
	public void setparentNode(NodeForCustomerInformation node) {
		parentNode=node;
	}
	
	public void setleftNode(NodeForCustomerInformation node) {
		leftNode=node;
	}
	
	public void setrightNode(NodeForCustomerInformation node) {
		rightNode=node;
	}
	
	public NodeForCustomerInformation getparentNode() {
		return parentNode;
	}
	
	public NodeForCustomerInformation getleftNode() {
		return leftNode;
	}
	
	public NodeForCustomerInformation getrightNode() {
		return rightNode;
	}
	
	public T getKey() {
		return CustomerInformation;
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
