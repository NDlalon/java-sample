import java.util.Arrays;

public class heapsort {
	
	public heapsort() {
		int[] A =new int[] {4,1,3,2,16,9,10,14,8,7};
		System.out.println("Before"+Arrays.toString(A));
		int[] B =Heapsort(A);
		System.out.println("After"+Arrays.toString(B));
	}
	
	public int[] Heapsort(int[] A) {
		int[] B=new int [A.length];
		
		buildMaxHeap(A);
		for(int i=A.length-1;i>=0;i--) {
			B[i]=A[0];
			A[0]=A[i];
			A[i]=0;
			MaxHeapify(A,0);
		}
		
		return B;
	}
	
	public void MaxHeapify(int[] A,int i) {
		int L=left(i);
		int R=right(i);
		int Large=0;
		
		if(L<A.length && A[L]>A[i] ) {
			Large=L;
		}
		else {
			Large=i;
		}
		if(R<A.length && A[R]>A[Large]) {
			Large=R;
		}
		if(Large!=i) {
			int temp=A[i];
			A[i]=A[Large];
			A[Large]=temp;
			MaxHeapify(A,Large);
		}
	}
	
	public void buildMaxHeap(int[] A) {
		int n=(int)Math.floor(A.length/2);
		for(int i=n-1;i>=0;i--) {
			MaxHeapify(A,i);
		}
	}
	
	public int left(int i) {
		return i=i*2+1;
	}
	
	public int right(int i) {
		return i=i*2+2;
	}
}
