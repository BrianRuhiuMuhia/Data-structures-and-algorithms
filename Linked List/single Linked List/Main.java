public class Main {
public static void main(String[]  args){
SingleLinkedList<Integer> list=new SingleLinkedList<Integer>();
list.insertNode(10);
list.insertNode(20);
list.insertNode(20);
list.insertNode(30);
list.insertNode(40);
list.insertNode(40);
list.insertNode(40);
list.insertNode(50);
list.insertNode(60);
list.printNodes();
list.removeDuplicates();
list.printNodes();
}    
}
class Node<T>{
    T data=null;
    Node<T> next=null;
    public Node(T data)
    {
this.data=data;
    }
    public T print(){
        return this.data;
    }
}
class SingleLinkedList<T>{
Node <T> head=null;
private int size=0;
public void insertNode(T data){
Node<T> node=new Node<T>(data);
if(this.head==null)
{
    this.head=node;
}
else{
    node.next=this.head;
    this.head=node;
}
this.size+=1;
}
public void insertHead(T data)
{
    Node <T> node =new Node<T>(data);
    if(this.head==null)
    {
    this.head=node;
    }
    else if(this.head!=null)
    {
        Node<T> prevHead=this.head;
        node.next=prevHead;
        this.head=node;
    }
    this.size++;
}
public void printNodes()
{
    Node<T> curr=this.head;
    while(curr != null){
        System.out.print(curr.data + "->");
        curr=curr.next;
    }
    System.out.print("null");
    System.out.println("");
}
public void insertAtEnd(T data)
{
Node<T> node=new Node<T>(data);
Node<T> curr=this.head;
while(curr!=null)
{
if(curr.next==null)
{
    curr.next=node;
    break;
}
curr=curr.next;
}
this.size++;
}
public void insertAtPosition(int pos, T data) {
    if (pos >= 0 && pos <= this.size()) {
        Node<T> newNode = new Node<>(data);
        if (pos == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node<T> curr = this.head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        this.size++;
    } else {
        System.out.println("Invalid position. Please choose a valid position.");
    }
}
public void deleteHead(){
    this.head=this.head.next;
    this.size--;
}
public void deleteLastNode(){
    if(this.head==null)
    {
        System.out.println("empty list");
    }
    else if(this.head.next==null){
this.head=null;
    }
    else{
        Node<T> curr=this.head;
    while(curr!=null)
    {
        if(curr.next.next==null)
        {
            curr.next=null;
            break;
        }
        curr=curr.next;
    }
    }
    
    this.size--;
}
public int size()
{
    return this.size;
}
public void insertNodeRecursively(T data)
{
Node<T> node=new Node<T>(data);
this.head=insert(node,this.head);
}
public Node<T> insert(Node<T> node,Node<T> curr)
{
if (curr==null)
{
    return node;
}
curr.next=insert(node, curr.next);
    return curr;
}
public Node<T> middleNode()
{
    Node<T> fastPointer=this.head;
    Node <T> slowPointer=this.head;
    while(fastPointer!=null && fastPointer.next!=null)
    {
        slowPointer=slowPointer.next;
        fastPointer=fastPointer.next.next;
    }
    return slowPointer;
}
public void reverse()
{
    Node<T> curr=this.head;
    Node <T> prev=null;
    while(curr!=null)
    {
        Node<T> temp=curr.next;
        curr.next=prev;
        prev=curr;
        curr=temp;
    }
    this.head=prev;
}
public T nthElementFromLast(int pos){
Node<T> forwardPtr=this.head;
Node<T> mainPtr=this.head;
int count=-1;
while(count<pos){
forwardPtr=forwardPtr.next;
count++;
}
while(forwardPtr!=null){
forwardPtr=forwardPtr.next;
mainPtr=mainPtr.next;
}
return mainPtr.data;
}
public T searchAtPos(int pos)
{
    Node<T> forwardPtr=this.head;
    int count=0;
    while(count<pos)
    {
        forwardPtr=forwardPtr.next;
        count++;
    }
    return forwardPtr.data;
}
public boolean searchNodeExist(Node<T> node)
{
Boolean exists=false;
Node<T> forwardPtr=this.head;
while(forwardPtr!=null)
{
if(forwardPtr.data.equals(node.data))
{
exists=true;
return exists;
}
forwardPtr=forwardPtr.next;
}
return exists;
}
public void removeDuplicates()
{
    Node<T> curr=this.head;
    while(curr!=null)
    {
        Node<T> temp=curr.next;
        if(temp!=null && curr.data.equals(temp.data))
        {
curr.next=temp.next;
temp.next=null;
        }
        else{
            curr=curr.next; 
        }
       
    }
}
}
