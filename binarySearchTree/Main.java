class Main{
    public static void main(String[] args) {
        Bst bst=new Bst();
        bst.insertNode(10);
        bst.insertNode(20);
        bst.insertNode(5);
        bst.insertNode(7);
        System.out.println(bst.largestNode(bst.root));
        System.out.println(bst.heightOfTree(bst.root));
    }
}
class Node{
    Node left=null;
    Node right=null;
    int data=0;
    public Node(int data){
        this.data=data;
    }
    public String toString()
    {
        return this.data +"";
    }
}
class Bst{
    Node root=null;
    public void insertNode(int data)
    {
Node node=new Node(data);
if(this.root==null)
{
    this.root=node;
}
else{
insert(node, this.root);
}
    }
    public void insert(Node newNode,Node root)
    {
if(root.data>newNode.data)
{
if(root.left==null)
{
    root.left=newNode;
}
else{
    insert(newNode,root.left);
    }

}
else if(root.data<newNode.data)
{
if(root.right==null)
{
    root.right=newNode;
}
else{
    insert(newNode, root.right);
}
}

    }
    public void preorder(Node root)
    {
        if(root==null)
        return;
        System.out.print(root+"-");
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.println(root+"-");
        inorder(root.right);
    }
    public void postorder(Node root)
    {
        if(root==null)
        return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root+"-");
    }
    public Node largestNode(Node root)
    {
        if(root.right==null)
        {
            return root;
        }
        return largestNode(root.right);
    }
public int heightOfTree(Node root)
{
    if(root==null)
    {
        return -1;
    }
return Math.max(heightOfTree(root.right),heightOfTree(root.left))+1;
}
}