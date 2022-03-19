public class Mergesort {
	public Mergesort() {
		int[] A=new int[] {5,7,9,0,8,21,6,4,1,3,2};
		int start=0;
		int end;
		end=A.length-1;
		mergesort(A,start,end);
		showarray(A);
	}
	
	public void mergesort(int []A,int start,int end) {			//陣列分割
		int mid=0;
		if(start<end) {
			mid=(end+start)/2;
			mergesort(A,start,mid);
			mergesort(A,mid+1,end);
			STBmerge(A,start,mid,end);
		}
	}
	
	public void STBmerge(int[] A,int start,int mid,int end) {		//陣列組合
		int[] la=new int [end-mid+2];
		int[] ra=new int [end-mid+2];
		int j=0;
		int k=0;
		for(int i=start;i<=mid;i++) {
			la[j]=A[i];
			j++;
		}
		for(int i=mid+1;i<=end;i++) {
			ra[k]=A[i];
			k++;
		}
		la[j]=Integer.MAX_VALUE;
		ra[k]=Integer.MAX_VALUE;
		j=k=0;
		for(int i=start;i<=end;i++) {
			if(la[j]<ra[k]) {
				A[i]=la[j];
				j++;
			}
			else {
				A[i]=ra[k];
				k++;
			}
		}
	}
	
	public void showarray(int []A) {			//顯示陣列
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Mergesort();
	}
}
