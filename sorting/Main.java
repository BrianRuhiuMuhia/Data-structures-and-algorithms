import java.util.Arrays;

class Main{
    public static void main(String[] args)
    {
int[] arr={5,7,9,10,3};
bubbleSort(arr);
System.out.println(Arrays.toString(arr));
    }

public static void bubbleSort(int[] arr)
{
int size=arr.length;
for(int i=0;i<size;i++)
{
for(int j=0;j<i;j++)
{
if(arr[i]<arr[j])
{
    int temp=arr[j];
    arr[j]=arr[i];
    arr[i]=temp;
}
}
}
}
    }
