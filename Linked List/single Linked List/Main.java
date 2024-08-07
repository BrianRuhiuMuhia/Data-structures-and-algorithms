public class Main {
public static void main(String[]  args){
SingleLinkedList<Integer> list=new SingleLinkedList<Integer>();
list.insertRecusively(50);
list.insertRecusively(40);
list.insertRecusively(60);
list.insertRecusively(10);
list.insertRecusively(40);
list.insertRecusively(20);
list.insertRecusively(30);
list.insertRecusively(40);
list.insertRecusively(20);

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
    node.next=this.head;
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
public void insertRecusively(T data)
{
Node<T> newNode=new Node<T>(data);
this.insertR(this.head, newNode);
}
public void insertR(Node<T> head,Node<T> node)
{
if(head==null)
{
    head=node;
    return;
}
else{
insertR(head.next, node);
}
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
public boolean floydsAlgo(){
    Node<T> fastPtr=this.head;
    Node<T> slowPtr=this.head;
    while(fastPtr!=null && slowPtr!=null && fastPtr.next!=null){
slowPtr=slowPtr.next;
fastPtr=fastPtr.next.next;
if(slowPtr.data.equals(fastPtr.data))
return true;
    }
    return false;
}
public Node<T> deleteNode(T data)
{
Node<T> curr=this.head;
Node<T> deletedNode=null;
if(curr.data.equals(this.head.data))
{
    this.deleteHead();
}
while(curr!=null){
    if(curr.next==null)
    {
        return deletedNode;
    }
if(curr.next.data.equals(data))
{
break;
}

curr=curr.next;
}
deletedNode=curr.next;
Node<T> temp=deletedNode.next;
curr.next=temp;
deletedNode.next=null;
return deletedNode;
}
public void deleteAtIndex(int pos)
{
    if(pos==1)
    {
        this.deleteHead();
    }
    Node<T> curr=this.head;
    Node<T> deletedNode=null;
    int count=1;
    while(count<pos-1){
        curr=curr.next;
        count+=1;
    }
    deletedNode=curr.next;
Node<T> temp=deletedNode.next;
curr.next=temp;
deletedNode.next=null;
}
public void deleteMiddleNode()
{
    Node<T> fastPtr=this.head;
    Node<T> slowPtr=this.head;
    while(fastPtr.next!=null && slowPtr.next!=null)
    {
        fastPtr=fastPtr.next.next;
        slowPtr=slowPtr.next;
    }
Node<T> temp=slowPtr;
Node<T> deletedNode=slowPtr;
deletedNode.data=temp.next.data;
deletedNode.next=temp.next.next;
temp=null;
}
public void deleteMiddleNode2()
{
    int count=0;
    Node<T> curr=this.head;
    while(curr!=null)
    {
curr=curr.next;
count++;
    }
    double middle=Math.floor(count/2);
    curr=this.head;
    for(int i=0;i<middle-1;i++)
    {
curr=curr.next;
    }
    Node<T> deletedNode=curr.next;
    curr.next=deletedNode.next;
    deletedNode=null;
}
public void rotateLinkedList(int count)
{
Node<T> curr=this.head;
for(int i=0;i<count-1;i++)
{
    curr=curr.next;
}
Node<T> newHead=curr.next;
curr.next=null;
curr=newHead;
while(curr.next!=null)
{
curr=curr.next;
}
Node<T> lastNode=curr;
lastNode.next=this.head;
this.head=newHead;
}
public void deleteAndMaintain(int m,int n)
{
Node<T> curr=this.head;
int num=0;
while(curr!=null)
{
if(num==n)
{
    int i=0;
while(i<n && curr.next!=null)
{
Node<T> deletedNode=curr.next;
curr.next=deletedNode.next;
deletedNode=null;
i++;
}
num=0;
}
else{
    num++;
    curr=curr.next;
}
}
}
public void deleteKthNode(int k)
{
    if(k==1 || k==0)
    {
        this.head=null;
    }
    else{
        int count=0;
        Node <T> curr=this.head;
        while(curr!=null)
        {
            if(count==(k-1) && curr.next!=null)
            {
        Node<T> deletedNode=curr.next;
        curr.next=deletedNode.next;
        deletedNode=null;
        count=0;
            }
            curr=curr.next;
            count++;
        }
    }

}
public void pairwiseSwap(){
    Node<T> curr=this.head;
    while(curr.next!=null && curr!=null)
    {
        swap(curr,curr.next);
        curr=curr.next.next;
    }
}
public void swap(Node<T> node_one,Node<T> node_two)
{
T temp=node_one.data;
T temp_one=node_two.data;
node_one.data=temp_one;
node_two.data=temp;
}
public void convertToCircularLinkedList()
{
    Node <T> curr=this.head;
    while(curr.next!=null)
    {
        curr=curr.next;
    }
    Node<T> tail=curr;
    tail.next=this.head;
}
public void deleteCycle()
{
    if(floydsAlgo())
    {
        Node<T> slowPtr=this.head;
        Node<T> fastPtr=this.head;
        while(fastPtr.next!=slowPtr && fastPtr!=null)
        {
            fastPtr=fastPtr.next;
        }
        fastPtr.next=null;
    }
}
public void swapKthPos(int k)
{
Node<T> firstPtr=this.head;
Node<T> secondPtr=this.head;
int count=0;
while(count<k)
{
    firstPtr=firstPtr.next;
    count++;
}
Node<T> swapFirst=firstPtr;
while(firstPtr!=null)
{
secondPtr=secondPtr.next;
firstPtr=firstPtr.next;
}
Node<T> swapLast=secondPtr;
T data=swapFirst.data;;
swapFirst.data=swapLast.data;
swapLast.data=data;

}

}
