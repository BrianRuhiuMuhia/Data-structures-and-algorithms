public class Main {
    public static void main(String[] args){
    DoublyLinkedList list=new DoublyLinkedList();
    list.prepend(50);
    list.prepend(10);
    list.prepend(20);
    list.prepend(30);
    list.prepend(100);
    list.prepend(300);
   System.out.println(list.hasCycle());
   list.removeLoop();
   list.printForward();
  
    }    
    }
    class Node{
        Node next;
        Node prev;
        int data;
    public Node(int data)
    {
    this.data=data;
    }
    public String toString(){
        return "" + this.data;
    }
    }
    class DoublyLinkedList{
        Node head;
        Node tail;
        int size=0;
        public Node deleteHead()
        {
            Node deletedNode=this.head;
            this.head=deletedNode.next;
            deletedNode.next.prev=this.head;
            return deletedNode;
        }
        public Node deleteTail(){
            Node deletedNode=this.tail;
            this.tail=deletedNode.prev;
            this.tail.next=null;
            return deletedNode;
        }
        public Node deleteNode(int data)
        {
    Node curr=this.head;
    while(curr!=null)
    {
        if(this.head.data==data)
        {
            return deleteHead();
        }
    if(curr.next.data==data){
    break;
    }
    curr=curr.next;
        }
        Node deletedNode=curr.next;
        curr.next=deletedNode.next;
        deletedNode.next.prev=curr;
        return deletedNode;
        }
        public Node deleteAtPos(int pos)
        {
            Node deletedNode=null;
            int count=0;
            Node curr=this.head;
            while(count<pos-1)
            {
                if(pos==0)
                {
                    return deleteHead();
                }
                count+=1;
                curr=curr.next;
            }
            deletedNode=curr.next;
            curr.next=deletedNode.next;
            deletedNode.next.prev=curr;
            return deletedNode;
        }
        public Node insertANodeAtPos(int data,int pos)
        {
            Node node=new Node(data);
    Node curr=this.head;
    int count=0;
    while(count<pos-1 && curr != null)
    {  
    curr=curr.next;
    count++;
    }
    
    node.next=curr.next;
    node.prev=curr;
    curr.next.prev=node;
    curr.next=node;
            return node;
        }
        public void append(int data)
        {
            Node node=new Node(data);
            if(this.head==null)
    {
    this.head=node;
    this.tail=node;
    }
    else{
        this.tail.next=node;
        node.prev=this.tail;
        this.tail=node;
        this.tail.next=this.head;
    }
    this.size++;
        }
       public void prepend(int data)
       {
        Node node=new Node(data);
    if(this.head==null)
    {
    this.head=node;
    this.tail=node;
    }
    else{
       node.next=this.head;
       this.head.prev=node;
       this.head=node;
       this.head.prev=this.tail;
       this.tail.next=this.head;
    }
    this.size++;
       }
       public void printForward(){
        Node curr=this.head;
        System.out.print("null <-> ");
        while(curr!=null)
        {
    System.out.print(curr + " <-> ");
    curr=curr.next;
        }
    System.out.print("null");
    System.out.println("");
       }
       public void printBackward(){
        Node curr=this.tail;
        System.out.print("null <-> ");
        while(curr!=null)
        {
            System.out.print(curr + " <-> ");
    curr=curr.prev;
        }
    System.out.print("null");
    System.out.println("");
       }
       public boolean hasCycle()
       {
        Node fastPtr=this.head;
        Node slowPtr=this.head;
        while(fastPtr!=null && slowPtr!=null && fastPtr.next!=null)
        {
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr)
            return true;
        }
        return false;
       }
       public void removeLoop()
       {
        if(!hasCycle())
        {
            System.out.println("no cycle");
        }
        else{
        Node fastPtr=this.head;
        Node slowPtr=this.head;
        slowPtr=this.head;
        fastPtr=this.head;
        while(fastPtr.next!=slowPtr)
        {
            fastPtr=fastPtr.next;
        }
        fastPtr.next=null;
       }
    }
}