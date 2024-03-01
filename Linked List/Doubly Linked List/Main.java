public class Main {
public static void main(String[] args){
DoublyLinkedList list=new DoublyLinkedList();
list.prepend(50);
list.prepend(10);
list.prepend(20);
list.prepend(30);
list.printForward();
list.printBackward();
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
    while(curr!=null)
    {
System.out.print(curr + "->");
curr=curr.next;
    }
System.out.print("null");
System.out.println("");
   }
   public void printBackward(){
    Node curr=this.tail;
    while(curr!=null)
    {
System.out.print(curr + "->");
curr=curr.prev;
    }
System.out.print("null");
System.out.println("");
   }
}