package recursion;

public class Main {
public static void main(String[] args)
{
print(10);
}    
public static double power(double n,double r)
{
    if(r==0)
    return 1.0;
    if(r<0)
    return 0.0;
    return power(n,r-1)*n;

}
public static void print(int n)
{
System.out.println(n);
if(n<=0)
return;
if(n==1)
return;
print(n-1);
}

}
