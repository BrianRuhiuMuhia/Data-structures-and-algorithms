package trees;
import java.util.ArrayList;
class Main{
    public static void main(String[] args){
final BST list=new BST();
list.insert(50);
list.insert(30);
list.insert(20);
list.insert(40);
list.insert(70);
list.insert(60);
list.insert(80);
System.out.println(list.heightOfTree(list.root));
list.levelOrder();
System.out.println(list.search(list.root, 100));
    }
}
class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
     this.data = data;
    }
    public String toString()
    {
     return data + "";
    }
     
 }
class BST {
    public trees.Node root;
    public BST() {
        this.root=null;
    }
    public void insert(int data) {
        Node node = new Node(data);
        if(this.root==null)
        {
this.root=node;
        }
        else{
this.insertNode(this.root, node);
        }

    }
    private void insertNode(Node root,Node node){
       
            if(root.data>node.data){
                if(root.left==null)
                {
                    root.left=node;
                }
                else{
                    insertNode(root.left,node);
                }
            }
            else if(root.data<node.data)
            {
                if(root.right==null)
                {
                    root.right=node;
                }
                else{
                    insertNode(root.right,node);
                }
            }
        }
public int heightOfTree(Node root)
{
    if(root==null)
    return 0;
return Math.max(heightOfTree(root.left),heightOfTree(root.right))+1;
}
public void preOrder(Node root)
{
    if(root==null)
    return;
    System.out.print(root+" ");
    preOrder(root.left);
    preOrder(root.right);
}
public void inOrder(Node root)
{
if(root==null)
return;
inOrder(root.left);
System.out.print(root+" ");
inOrder(root.right);
}
public void postOrder(Node root)
{
    if(root==null)
    return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root+" ");
    
}
public Node search(Node node,int data)
{
if(node==null)
return null;
if(node.data==data)
{
return node;
}
else{
    if(node.data>data)
    {
      return  this.search(node.left,data);
    }
    else{
        return this.search(node.right,data);
    }
}

}
public void levelOrder()
{
ArrayList<Node> queue=new ArrayList<>();
queue.add(queue.size(),this.root);
while(queue.size()>0)
{
Node popped=queue.remove(0);
System.out.print(popped.data + " ");
if(popped.left!=null)
{
    queue.add(queue.size(),popped.left);
}
if(popped.right!=null){
    queue.add(queue.size(),popped.right);
}
}
}
    public String toString()
    {
        return root.toString();
    }
}
