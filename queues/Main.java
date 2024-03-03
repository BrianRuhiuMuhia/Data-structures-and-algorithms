package queues;

import java.util.ArrayList;

public class Main {
    Queue queue=new Queue();
}
class Queue{
    private ArrayList<Integer> list=null;
    public Queue(){
        this.list=new ArrayList<>();
    }
    public boolean isEmpty()
    {
        return this.list.isEmpty();
    }
    public int enqueue(int data)
    {
    this.list.add(this.list.size(),data);
return data;
    }
    public int dequeue()
    {
        //time complexity should be o(1)
        //time complexity of the algorithm is o(n)
        return this.list.remove(0);
    }
    public int peek(){
        return this.list.get(this.list.size()-1);
    }
}