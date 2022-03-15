package data_structure;

import java.io.IOException;
import java.util.Stack;

public class Binary_Tree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(){

        }

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static Node root = null;

    public static void create(Integer[] arr){
        Stack<Node> stk = new Stack<>();
        for(Integer i : arr){
            if(root == null){
                root = new Node(i);
                stk.push(root);
            }
            else if(i != null){
                Node top = stk.peek();
                Node temp = new Node(i);
                stk.push(temp);
                if(top.left == null){
                    top.left = temp;
                }
                else{
                    top.right = temp;
                }
            }
            else{
                stk.pop();
            }
        }
    }

    public static void display(Node root){
        if(root == null){
            return;
        }
        System.out.println((root.left==null?".->":(root.left.data+"->"))+" "+root.data+" "+(root.right==null?"<-.":("<-"+root.right.data) ));
        display(root.left);
        display(root.right);
    }

    private static int menu()throws IOException{
        System.out.println("1 - Display");
        return Input.input_int();
    }

    private static Integer[] testCase(){
        Integer[] arr = {10,20,40,null,50,80,null,null,null,30,60,null,70};
        return arr;
    }
    public static void main(String[] args) throws IOException {
        Integer[] arr = testCase();//Input.input_Intarr(" ");

        create(arr);
        while(true){
            switch(menu()){
                case 0:
                    System.exit(0);
                case 1:
                    Node temp = root;
                    display(temp);
                    break;
                default:
                    continue;
            }
        }
    }
}
