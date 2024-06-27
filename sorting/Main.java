import java.util.Arrays;

class Main{
    public static void main(String[] args)
    {
int[] arr={5,7,9,10,3};
selectionSort(arr);
System.out.println(Arrays.toString(arr));
    }
public static void bubbleSort(int[] arr)
{
for(int i=0;i<arr.length;i++)
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
public static void selectionSort(int[] arr)
{
for(int i=0;i<arr.length-1;i++)
{
for(int j=i+1;j<arr.length-1;j++)
{
    if(arr[j]>arr[i])
    {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
}
}
public static void insertionSort(int[] arr){
for(int i=1;i<arr.length;i++)
{
int key=arr[i];
int j=i-1;
while(j>=0 && arr[j]>key)
{
arr[j+1]=arr[j];
j--;
}
arr[j+1]=key;
}

}


    }
