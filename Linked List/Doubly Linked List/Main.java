public class Main {
public static void main(String[] args){
DoublyLinkedList list=new DoublyLinkedList();
list.append(2);
list.prepend(1);
list.prepend(1);
list.prepend(2);
list.printForward();
System.out.println(list.isPalidrome());
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
   public boolean hasCycle()
   {
    Node fastPtr=this.head;
    Node slowPtr=this.head;
    while(fastPtr!=null && slowPtr!=null && fastPtr.next!=null)
    {
        slowPtr=slowPtr.next;
        fastPtr=fastPtr.next.next;
        if(slowPtr.data==fastPtr.data)
        return true;
    }
    return false;
   }
   public void removeCycle(){
    if(hasCycle()==false)
    {
        System.out.println("Has a Cycle");
    }
    else{
        Node fastPtr=this.head;
        Node slowPtr=this.head;
        while(fastPtr!=null && slowPtr!=null && fastPtr.next!=null)
        {
            if(fastPtr==slowPtr)
            {
                break;
            }
        }
        slowPtr=head;
        fastPtr=head;
        while(fastPtr.next!=slowPtr)
        {
            fastPtr=fastPtr.next;
        }
        fastPtr.next=null;
    }
   }
   public void reverse()
   {
    Node curr=this.head;
    Node prev=null;
    while(curr!=null)
    {
        Node temp=curr.next;
        curr.prev=temp;
        curr.next=prev;
        prev=curr;
        curr=temp;
    }
    this.head=prev;
   }
   public int count()
{
Node curr=this.head;
int count=0;
while(curr!=null)
{
curr=curr.next;
count++;
}
return count;
}
public void selectionSort()
{
for(Node curr=this.head;curr!=null;curr=curr.next)
{
for(Node j=curr.next;j!=null;j=j.next)
{
if(curr.data>j.data)
{
    int temp=curr.data;
    curr.data=j.data;
    j.data=temp;
}
}
}
}
public void bubbleSort()
{
    for(Node curr=this.head;curr!=null;curr=curr.next)
    {
        for(Node j=this.head;j!=curr;j=j.next)
        {
if(curr.data<j.data)
{
    int temp=curr.data;
    curr.data=j.data;
    j.data=temp;
}
        }
    }
}
public void insertionSort()
{
    for(Node curr=this.head.next;curr!=null;curr=curr.next)
    {
        Node key=curr;
        Node j=curr.prev;
        while(j!=null && key.data>j.data)
        {
j.next.data=j.data;
j=null;
        }
        j=curr.next;
        j.data=key.data;
    }
}
public boolean isSorted()
{
    Node curr=this.head;
    while (curr.next!=null)
    {
        if(curr.data>curr.next.data)
        {
            return false;
        }
        curr=curr.next;
    }
    return true;
}
public void deleteDuplicates()
{
Node curr=this.head;
while(curr!=null)
{
    if(curr.next!=null && curr.data==curr.next.data)
    {
        curr.next=curr.next.next;
    }
    else{
        curr=curr.next;
    }
}
}
public boolean isPalidrome()
{
    Node curr=this.head;
    Node last=this.tail;
    while(curr.next!=null && last.prev!=null)
    {
if(curr.data!=last.data)
{
    return false;
}
curr=curr.next;
last=last.prev;
    }
    return true;
}
}