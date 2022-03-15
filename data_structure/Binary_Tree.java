package data_structure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

    private static int getSize(Node root){
        if(root == null){
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    private static int getSum(Node root){
        if(root == null){
            return 0;
        }
        return getSum(root.left) + getSum(root.right) + root.data;
    }

    private static int getMax(Node root){
        if(root.left == null && root.right == null){
            return root.data;
        }
        if(root.left != null && root.right != null){
            return Math.max(root.data,Math.max(getMax(root.left), getMax(root.right)));
        }
        else if(root.left != null){
            return Math.max(root.data,root.left.data);
        }
        else{
            return Math.max(root.data,root.right.data);
        }
    }

    private static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left)+1,getHeight(root.right)+1);
    }

    private static void getPreorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        getPreorder(root.left);
        getPreorder(root.right);
    }

    private static void getPostorder(Node root){
        if(root == null){
            return;
        }
        getPostorder(root.left);
        getPostorder(root.right);
        System.out.print(root.data+" ");
    }

    private static void getInorder(Node root){
        if(root == null){
            return;
        }
        getInorder(root.left);
        System.out.print(root.data+" ");
        getInorder(root.right);
    }

    private static void getLevelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.peek();
            q.poll();
            if(top.left != null){
                cq.add(top.left);
            }
            if(top.right != null){
                cq.add(top.right);
            }
            System.out.print(top.data+" ");
            if(q.isEmpty()){
                q = cq;
                cq = new LinkedList<>();
                System.out.println();
            }
        }
    }

    private static ArrayList<Integer> getPathtoRoot(Node root, int data){
        if(root.data == data){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        if(root.left != null){
            ArrayList<Integer> arr = getPathtoRoot(root.left,data);
            if(arr.size() > 0){
                arr.add(root.data);
                return arr;
            }
        }
        if(root.right != null){
            ArrayList<Integer> arr = getPathtoRoot(root.right,data);
            if(arr.size() > 0){
                arr.add(root.data);
                return arr;
            }
        }
        return new ArrayList<>();
    }

    private static int menu()throws IOException{
        System.out.println("1 - Display");
        System.out.println("2 - Size");
        System.out.println("3 - Sum of tree");
        System.out.println("4 - Height of tree");
        System.out.println("5 - Maximum in the tree");
        System.out.println("6 - PreOrder traversal");
        System.out.println("7 - InOrder traversal");
        System.out.println("8 - PostOrder traversal");
        System.out.println("9 - LevelOrder traversal");
        System.out.println("10 - Find path to Root");
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
                case 2:
                    temp = root;
                    System.out.println("Size of tree : "+getSize(temp));
                    break;
                case 3:
                    temp = root;
                    System.out.println("Sum of tree : "+getSum(temp));
                    break;
                case 4:
                    temp = root;
                    System.out.println("Height of tree : "+getHeight(temp));
                    break;
                case 5:
                    temp = root;
                    System.out.println("Maximum of tree : "+getMax(temp));
                    break;
                case 6:
                    temp = root;
                    getPreorder(temp);
                    System.out.println();
                    break;
                case 7:
                    temp = root;
                    getInorder(temp);
                    System.out.println();
                    break;
                case 8:
                    temp = root;
                    getPostorder(temp);
                    System.out.println();
                    break;
                case 9:
                    temp = root;
                    getLevelOrder(temp);
                    break;
                case 10:
                    temp = root;
                    int n = Input.input_int();
                    ArrayList<Integer> path = getPathtoRoot(temp,n);
                    for(int i : path){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    break;
                default:
                    continue;
            }
        }
    }
}
