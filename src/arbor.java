/**
 * Created by hozan on 03.05.2016.
 */
public class arbor
{
   Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }

                }
            }

        }
    }

    public void transersal(Node focusNode)
    {
        if(focusNode != null)
        {
            //in ordine transversala
           transersal(focusNode.leftChild);
            System.out.println(focusNode.key + " = " + focusNode.name);
            transersal(focusNode.rightChild);
        }
    }
    public Node findNode (int key)
    {
        Node focusNode = root;

        while(focusNode.key != key)
        {
            if(key < focusNode.key)
            {
                focusNode = focusNode.leftChild;
            }
            else
            {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }
public  boolean remove(int key)
{
    //incepem din varful arborelui
    Node focusNode = root;
    Node parent = root;

    //variabila ne va spune unde sa cautam
    boolean isItALeftChild = true;

    while(focusNode.key != key)
    {
        parent = focusNode;
        //satnga
        if(focusNode.key != key)
        {
            isItALeftChild = true;
            focusNode = focusNode.leftChild;
        }
        else
        {
            //dreapta
            isItALeftChild = false;
            focusNode = focusNode.rightChild;
        }
        //nodu nu a fost gasit
        if(focusNode == null)
            return false;

    }
    // daca nodul nu are children il stergem
    if(focusNode.leftChild == null && focusNode.rightChild == null)
    {
        //daca e radacina, o stergem
        if(focusNode == root)
            root = null;

        //daca a fost marcata ca left child a unui parinte stergem referinta din parinte
        else if(isItALeftChild)
            parent.leftChild = null;
        else
        //vice versa cu right child
            parent.rightChild = null;
    }
    // daca nu sunt right childs
    else if(focusNode.rightChild == null)
    {
        if (focusNode == root)
            root = focusNode.leftChild;
        //if focus Node was on the left of parent move the focus Nodes left child up to the parent node
        else if(focusNode.rightChild == null)
            parent.leftChild = focusNode.leftChild;
        //vice versa for the right child
        else
            parent.rightChild = focusNode.leftChild;
    }
    else if(focusNode.leftChild == null)
    {
        // if no left child
        if(focusNode == root)
            root = focusNode.rightChild;
        //if focus node was on the left of parent move the focus NOdes right child up to the parent node
        else if(isItALeftChild)
            parent.leftChild = focusNode.rightChild;
        else
        //vice versa for the right child
            parent.rightChild = focusNode.rightChild;
    }
    //two children so i need to find the deleted nodes replacement
    else
    {
        Node replacement = getReplacementNode(focusNode);
        //if the focusNOde is root replace root with the replacement
        if (focusNode == root)
            root = replacement;
        //if the deleted node was a left child make the replacemnet the left child
        else if(isItALeftChild)
            parent.leftChild = replacement;
        //vice versa if it was a right child
        else
            parent.rightChild = replacement;
        replacement.leftChild = focusNode.leftChild;
    }
    return true;
}

public Node getReplacementNode(Node replacedNode)
{
    Node replacementParent = replacedNode;
    Node replacement = replacedNode;

    Node focusNode = replacedNode.rightChild;

    //while there are no more left children
    while(focusNode != null)
    {
        replacementParent = replacement;
        replacement = focusNode;
        focusNode = focusNode.leftChild;
    }
    //if the replacement isnt the right child move the rep into the parents leftChild
    //slot and move the replaced nodes right child into the rep rightChild
    if(replacement != replacedNode.rightChild)
    {
        replacementParent.leftChild = replacement.rightChild;
        replacement.rightChild  = replacedNode.rightChild;
    }
return replacement;
}
    public static void main(String[] args)
    {
        arbor a = new arbor();

        a.addNode(4, "Ovidiu");
        a.addNode(3, "Dan");
        a.addNode(1, "Beni");
        a.addNode(2, "Liviu");

        a.transersal(a.root);
        a.remove(3);
        a.transersal(a.root);

    }
}

class Node
{
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name)
    {
        this.key = key;
        this.name = name;
    }
}
