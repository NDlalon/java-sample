
public class CustomerInformation implements Comparable<CustomerInformation> {
	
	protected String Account="";
	protected String Password="";
	protected String Name="";
	protected String Sex="";
	protected String City="";
	protected String Age="";
	
	public CustomerInformation (String Account,String Password,String Name,String Sex,String City,String Age) {
		this.Account=Account;
		this.Password=Password;
		this.Name=Name;
		this.Sex=Sex;
		this.City=City;
		this.Age=Age;
	}
	
	public void setAcount(String Account) {
		this.Account=Account;
	}
	
	public void setPassword(String Password) {
		this.Password=Password;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public void setSex(String Sex) {
		this.Sex=Sex;
	}
	
	public void setCity(String City) {
		this.City=City;
	}
	
	public void setAge(String Age) {
		this.Age=Age;
	}
	
	public String getAccount() {
		return Account;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getSex() {
		return Sex;
	}
	
	public String getCity() {
		return City;
	}
	
	public String getAge() {
		return Age;
	}
	
	public String getInformation() {
		String Info=Account+","+Password+","+Name+","+Sex+","+City+","+Age;
		return Info;
	}

	@Override
	public int compareTo(CustomerInformation o) {
		return Account.compareTo(o.Account);
	}
	
}
