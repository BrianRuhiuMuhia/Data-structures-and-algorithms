public class Main {
public static void main(String[] args){
DoublyLinkedList list=new DoublyLinkedList();
list.prepend(50);
list.prepend(10);
list.prepend(20);
list.prepend(30);
list.append(100);
list.append(300);
list.printForward();
list.deleteNode(10);
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
    public Node deleteNode(int data)
    {
Node curr=this.head;
while(curr!=null)
{
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
}