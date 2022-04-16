package chainedHashExample;

import java.util.Hashtable;

public class chainedHash {
	int m=5;
	Table[] hashtable =new Table[m];
	String[] carType=new String[] {"Toyota","Volkswagen","Honda","BMW","Ford",
								 	"Nissan","Tesla","Suzuki","Mazda","Subaru",
									"Ferrari","Audi","Lexus","Volvo","Mitsubishi"};
	
	public chainedHash() {
		car[] car=new car[carType.length]; 
		car carsearch ;
		int x=20;
		
		for(int i=0;i<car.length;i++) {
			car[i]= new car(i,carType[i]);
			chainedHashInsert(car[i]);
		}
		
		printTable();
		
		System.out.println();
		
		carsearch=chainedHashSearch(x);
		if(carsearch!=null) {
			System.out.println("Find key "+carsearch.getkey()+", value="+carsearch.getvalue());
		}
		else {
			System.out.println("Key "+x+" is not found");
		}
		
		System.out.println();
		
		chainedHashDelte(car[5]);
		printTable();
	}
	
	public void chainedHashInsert(car car) {
		int hash =gethash(car.getkey());
		if(hashtable[hash]!=null) {
			hashtable[hash].insert(car);
		}
		else {
			hashtable[hash]=new Table();
			hashtable[hash].insert(car);
		}
	}
	
	public car chainedHashSearch(int key) {
		int hash=gethash(key);
		
		car[] car =hashtable[hash].getlist();
		for(int i=0;i<car.length;i++) {
			if(car[i].getkey()==key)
				return car[i];
		}
		return null;
	}
	
	public void chainedHashDelte(car car) {
		int hash = gethash(car.getkey());
		car[] cars=hashtable[hash].getlist();
		
		for(int i=0;i<cars.length;i++) {
			if(cars[i].getkey()==car.getkey() && cars[i].getvalue()==car.getvalue()) {
				hashtable[hash].delete(i);
			}
		}
	}
	
	public void printTable() {
		for(int i=0;i<hashtable.length;i++) {
			car[] car=hashtable[i].getlist();
			System.out.println("HashTable["+i+"]=");
			for(int j=0;j<car.length;j++) {
				System.out.print("{key="+car[j].getkey()+" ,value="+car[j].getvalue()+"}  ");
			}
			System.out.println();
		}
	}
	
	public int gethash(int key) {
		return key%m;
	}
	
	public static void main(String[] args) {
		new chainedHash();
	}

}
