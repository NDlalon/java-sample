
public class CustomerBinarySeacherTree {
	
	public NodeForCustomerInformation root;
	
	public CustomerBinarySeacherTree(NodeForCustomerInformation root) {
		this.root=root;
	}
	
	public void Insertion(CustomerInformation Key) {
		NodeForCustomerInformation point=root;
		System.out.println("Insert Key:"+Key.getAccount());
		if(root==null) {
			root=new NodeForCustomerInformation(Key);
		}
		else {
			while(true) {
				if(Key.compareTo(point.getKey())<0) {
					if(point.getleftNode()==null) {
						NodeForCustomerInformation x =new NodeForCustomerInformation(Key);
						x.setparentNode(point);
						point.setleftNode(x);
						System.out.println("  Insert to the left node \tParent node:"+point.getKey().getAccount());
						break;
					}
					else {
						point=point.getleftNode();
					}
				}
				else {
					if(point.getrightNode()==null) {
						NodeForCustomerInformation x=new NodeForCustomerInformation(Key);
						x.setparentNode(point);
						point.setrightNode(x);
						System.out.println("  Insert to the right node\tParent node:"+point.getKey().getAccount());
						break;
					}
					else {
						point=point.getrightNode();
					}
				}
			}
		}
	}
	
	public void Treewalk(NodeForCustomerInformation node) {
		if(node!=null) {
			Treewalk(node.getleftNode());
			System.out.print(node.getKey().getAccount()+" -> ");
			Treewalk(node.getrightNode());
		}
	}
	
	public NodeForCustomerInformation TreeSearch(NodeForCustomerInformation node,CustomerInformation Key) {
		if(node==null||node.getKey().compareTo(Key)==0) {
			return node;
		}
		else {
			if(Key.compareTo(node.getKey())<0) {
				System.out.print(node.getKey().getAccount()+" -> ");
				return TreeSearch(node.getleftNode(),Key);
			}
			else {
				System.out.print(node.getKey().getAccount()+" -> ");
				return TreeSearch(node.getrightNode(),Key);
			}
		}
	}
	
	public NodeForCustomerInformation Transplant(NodeForCustomerInformation d,NodeForCustomerInformation r) {
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
	
	public void TreeDelete(NodeForCustomerInformation delete) {
		
		if(delete!=null) {
			System.out.println("Delete:"+delete.getKey().getAccount());
			if(delete.getleftNode()==null) {
				root=Transplant(delete,delete.getrightNode());
			}
			else if(delete.getrightNode()==null) {
				root=Transplant(delete,delete.getleftNode());
			}
			else {
				if(delete.getparentNode()==null) {
					delete.getleftNode().setparentNode(Minimum(delete.getrightNode()));
					Minimum(delete.getrightNode()).setleftNode(delete.getleftNode());;
					delete.getrightNode().setparentNode(null);
					root=delete.getrightNode();
				}
				else if(delete.getparentNode().getleftNode()==delete) {
					delete.getrightNode().setparentNode(delete.getparentNode());
					delete.getparentNode().setleftNode(delete.getrightNode());
					delete.getleftNode().setparentNode(Minimum(delete.getrightNode()));
					Minimum(delete.getrightNode()).setleftNode(delete.getleftNode());;
					while(delete.getparentNode()!=null) {
						delete=delete.getparentNode();
					}
					root=delete;
				}
				else {
					delete.getrightNode().setparentNode(delete.getparentNode());
					delete.getparentNode().setrightNode(delete.getrightNode());
					delete.getleftNode().setparentNode(Minimum(delete.getrightNode()));
					Minimum(delete.getrightNode()).setleftNode(delete.getleftNode());;
					while(delete.getparentNode()!=null) {
						delete=delete.getparentNode();
					}
					root=delete;
				}
			
			}
		}
		else {
			System.out.println("Delete fall\nThe entered was not found");
		}
	}
	
	public NodeForCustomerInformation Minimum(NodeForCustomerInformation node) {
		while(node.getleftNode()!=null) {
			node=node.getleftNode();
		}
		
		return node;
	}
	
	public NodeForCustomerInformation Maximum(NodeForCustomerInformation node) {
		while(node.getrightNode()!=null) {
			node=node.getrightNode();
		}
		
		return node;
	}
	
	public NodeForCustomerInformation getRoot() {
		return root;
	}
	
}
