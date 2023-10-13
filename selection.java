import java.util.*;
public class selection
{
    public static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void selectionsort(int a[],int n)
    {
        int counter=0;
        for(int i=0;i<n-1;i++)
        {
            int min=i;
           
            for(int j=i+1;j<n;j++)
            {
               
                if (a[j]< a[min])
                min=j;
                
            }
            swap(a,i,min);
           
        }
    }
    public static void main (String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=s.nextInt();
        int a[]=new int[n];
        
        System.out.println("Enter the values:");
        for(int i=0;i<n;i++)
        {
            
            a[i]=s.nextInt();
        }
        System.out.println("Before sorting:");
        for(int i=0;i<a.length;i++)
        {
            
            System.out.print(a[i]+" ");
            

        }    
        selectionsort(a,a.length);
        System.out.println("\nAfter sorting:");
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");
        long start=System.nanoTime();
        long end=System.nanoTime(); 
        long execution=end-start;
        System.out.println("\nExecution Time in nano seconds:"+execution);     
        
    }
}