/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binary_search_tree;

/**
 *
 * @author JUNAID COMPUTER
 */
 import java.util.Queue;
import java.util.LinkedList;
public class Binary_search_tree {
    Node root;

public Binary_search_tree(int data){
root =new Node(data);
}
    
      public void insert(int value){
        root = insertRec(root,value);
    }
    public Node insertRec(Node root,int value){
        if(root == null){
            root = new Node(value);
        }
        else if(value<root.value){
            root.left = insertRec(root.left,value);
        }else{
            root.right = insertRec(root.right,value);
        }
        return root;
    }
        public boolean isEmpty(){
        return root== null;
    }
        
        // method for counting nodes
        int countNodes() {
    return countNodesRecursive(root);
}

private int countNodesRecursive(Node root) {
    if (root == null) {
        return 0;
    }
    return 1 + countNodesRecursive(root.left) + countNodesRecursive(root.right);
}

// Method for searching node
public boolean search(int value) {
    return searchRecursive(root, value);
}

public boolean searchRecursive(Node current, int value) {
    if (current == null) {
        return false;
    }
    if (value == current.value) {
        return true;
    }
    return value < current.value
            ? searchRecursive(current.left, value)
            : searchRecursive(current.right, value);
}
 
     
         //Inorder 
    public void inorder(){
        inorderRec(root);
    
    }
    
    public void  inorderRec(Node root){
    if(root != null){
        inorderRec(root.left);
        System.out.print(root.value+" ");
        inorderRec(root.right);
    } 
    }

   public void preorder(){
        preorderRec(root);
        System.out.println();
    }
    public void preorderRec(Node root){
        if(root != null){
            System.out.print(root.value+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    
        public void postorder(){
        postorderRec(root);
    }
    public void postorderRec(Node root){
        if(root!= null){
            preorderRec(root.left);
            preorderRec(root.right);
            System.out.print(root.value+" ");
        }
    }

    public void levelorder(){
     Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             Node current = queue.poll();
                System.out.print(current.value+" ");
             if(current.left != null){
                 queue.add(current.left);
             }
             if(current.right != null){
                 queue.add(current.right);
             }
         }
    }


    public static void main(String[] args) {
         Binary_search_tree bst = new Binary_search_tree(50);

        
        int[] values = { 30, 20, 40, 70, 60, 80};
        for (int value : values) {
            bst.insert(value);
            System.out.println("Inserted " + value + ", Total nodes: " + bst.countNodes());
        }

        
        System.out.println("Search 20: " + bst.search(20)); // true
        System.out.println("Search 60: " + bst.search(60)); // true
        System.out.println("Search 90: " + bst.search(90)); // false

       
        System.out.println("In-order Traversal:");
        bst.inorder();

        System.out.println("Pre-order Traversal:");
        bst.preorder();

        System.out.println("Post-order Traversal:");
        bst.postorder();

        System.out.println("\nLevel-order Traversal:");
        bst.levelorder();
    }
}

  
    

