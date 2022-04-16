package chainedHashExample;

import java.util.LinkedList;

public class Table {
	private LinkedList<car> list= new LinkedList<car>();
	
	public void insert(car car) {
		list.add(car);
	}
	
	public void delete(int index) {
		list.remove(index);
	}
	
	public car[] getlist() {
		car[] car=new car[list.size()];
		for(int i=0;i<car.length;i++) {
			car[i]=list.get(i);
		}
		
		return car;
	}
}
