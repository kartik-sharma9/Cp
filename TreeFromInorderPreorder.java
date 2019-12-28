package com.company;

class Node{

    char data;
    Node left,right;

    public Node(char data){
        this.data=data;
        left=right=null;
    }
}
public class TreeFromInorderPreorder {

    public Node buildTree(char in[],char pre[], int startIndex, int LastIndex, char data){

        if(startIndex > LastIndex)
            return null;

        Node tNode = new Node(pre[startIndex++]);

        if(LastIndex == startIndex)
            return tNode;

        //int index = search(in,startIndex,LastIndex,tNode.data);

       // tNode.left
        return null;
    }

    public static void main(){
        char[] inOrder = {};
        char[] preorder = {};

    }
}
