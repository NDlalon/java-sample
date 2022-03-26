import java.util.Arrays;

public class quicksort {
	public quicksort() {
		int[] A=new int [] {5,8,4,6,7,9,1,3};
		System.out.println("Before:");
		System.out.println(Arrays.toString(A));
		Quicksort(A,0,A.length-1);
		System.out.println("After:");
		System.out.println(Arrays.toString(A));
	}
	
	public void Quicksort(int[] A,int start,int end) {
		int mid=0;
		if(start<end) {
			mid=sort(A,start,end);
			Quicksort(A,start,mid-1);
			Quicksort(A,mid+1,end);
		}
		
	}
	
	public int sort(int[] A,int start,int end) {
		int p=start;
		int temp;
		for(int i=start;i<end;i++) {
			if(A[i]<A[end]) {
				temp=A[p];
				A[p]=A[i];
				A[i]=temp;
				p++;
			}
		}
		temp=A[end];
		A[end]=A[p];
		A[p]=temp;
		return p;
	}
}
