class Main{
    public static void main(String[] args){
System.out.println(isPalidrome("brian"));

    }
public static int secondLargestValue(int[] arr)
{
int largest=0;
int secondLargest=0;
for(int num: arr)
{
    if(num > largest)
    {
        secondLargest=largest;
        largest=num;
    }
    if(num>=secondLargest && num!=largest)
    {
        secondLargest=num;
    }
}
return secondLargest;
}   
 public static boolean isPalidrome(String str)
 {

String[] arrStr=str.split("");
int i=arrStr.length-1;
int j=0;
while(i>j)
{
    if(!arrStr[i].equals(arrStr[j]))
    {
        return false;
    }
    i--;
    j++;
}
return true;
 }
}