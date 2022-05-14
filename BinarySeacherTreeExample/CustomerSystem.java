import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CustomerSystem {
	
	NodeForCustomerInformation<CustomerInformation> root=null;
	CustomerBinarySeacherTree bst=new CustomerBinarySeacherTree(root);
	private int fileSize=0;
	
	public CustomerSystem() {
		
	}
	
	public void add() {
		CustomerInformation[] dataSet= getData();
		for(int i=0;i<fileSize;i++) {
			bst.Insertion(dataSet[i]);
		}
		root=bst.getRoot();
	}
	
	public NodeForCustomerInformation<CustomerInformation> search(String Account){
		CustomerInformation costomer =new CustomerInformation(Account,"","","","","");
		return bst.TreeSearch(root, costomer);

	}
	
	public void delete(String Account) {
		bst.TreeDelete(search(Account));
		root=bst.getRoot();
	}
	
	public CustomerInformation[] getData() {
		String dataPathWay="src/CustData.txt";
		CustomerInformation[] dataSet=new CustomerInformation[3000];
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File(dataPathWay)));
			String text="";
			int i=0;
			while((text=br.readLine())!=null) {
				String[] data=text.split(",");
				dataSet[i]=new CustomerInformation(data[0],data[1],data[2],data[3],data[4],data[5]);
				i++;
			}
			fileSize=i;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSet;
	}
	
}
