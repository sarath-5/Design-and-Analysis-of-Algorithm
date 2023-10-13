import java.util.Scanner;

public class MinMax {

	static Scanner sc = new Scanner(System.in);
	
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int a[];
	static int size;
	
	static void MinMax(int i, int j)
	{
		int max1, min1, mid;
		if(i==j)
		{
			max = min = a[i];
		}
		else
		{
			if(i == j-1){   
				if(a[i] < a[j]){
					max = a[j];
					min = a[i];
				}
				else{
					max = a[i];
					min = a[j];
				}
			}
			
			else{	
				mid = (i+j)/2;
				MinMax(i, mid);
				
				max1 = max;   
				min1 = min;
				MinMax(mid+1, j);
				if(max < max1) max = max1;//updating here
				if(min > min1) min = min1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Enter the size of the array: ");
		size = sc.nextInt();
		a = new int[size];
		System.out.println("Enter values:");
		for(int i=0; i< size; i++)
             {
			a[i] = sc.nextInt();
             }
		MinMax(0, size-1);
		System.out.println("Max value: "+max+"\nMin value: "+min);
	}

}