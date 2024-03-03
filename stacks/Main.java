package stacks;
import java.util.ArrayList;
class Main{
    public static void main(String[] args)
    {
Stack stack=new Stack();
stack.push(1);
stack.push(2);
stack.push(3);

    }
}
class Stack{
    ArrayList<Integer>list=null;
    public Stack(){
    list=new ArrayList<Integer>();
    }
    public int push(int data)
    {
     this.list.add(this.list.size(),data);
     return data;
    }
    public int pop(){
        int deleted=list.remove(list.size()-1);
        return deleted;
    }
    public int peek(){
        return list.get(list.size()-1);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}