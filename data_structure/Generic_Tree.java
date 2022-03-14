package data_structure;
import java.io.*;
import java.util.*;
public class Generic_Tree {

    private static Node root = null;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static void create(int[] arr) {
        Stack<Node> stk = new Stack<>();
        for(int i : arr){
            if(i == -1){
                if(stk.isEmpty()){
                    System.out.println("Unhandled Exception");
                    return;
                }
                stk.pop();
            }
            else{
                Node temp = new Node();
                temp.data = i;
                if(stk.size() == 0){
                    root = temp;
                    stk.push(temp);
                }
                else{
                    stk.peek().children.add(temp);
                    stk.push(temp);
                }
            }
        }
    }

    private static int size(Node root) {
        if(root == null){
            return 0;
        }
        int s = 0;
        for(Node temp : root.children){
            int cs = size(temp);
            s += cs;
        }
        s++;
        return s;
    }

    private static int max(Node root) {
        if(root == null){
            return 0;
        }
        int mx = -1;
        for(Node temp : root.children){
            mx = Math.max(mx, max(temp));
        }
        return Math.max(mx, root.data);
    }

    private static void print(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        for(Node temp : root.children){
            print(temp);
        }
        return;
    }

    private static int height(Node root) {
        if(root == null){
            return -1;
        }
        if(root.children.size() == 0){
            return 0;
        }
        int ht = 0;
        for(Node temp : root.children){
            ht = Math.max(ht,height(temp)+1);
        }
        return ht;
    }

    private static void traversal(Node root){
        if(root == null){
            return;
        }
        System.out.println("Node pre : "+root.data);
        for(Node temp : root.children){
            System.out.println("Edge pre "+root.data+" - "+temp.data);
            traversal(temp);
            System.out.println("Edge post "+root.data+" - "+temp.data);
        }
        System.out.println("Node post : "+root.data);
        return;
    }

    private static void levelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        q.add(root);
        System.out.println(q.peek().data);
        while(!cq.isEmpty()){
            while(!q.isEmpty()){
                for(Node temp : q.peek().children){
                    System.out.print(" "+temp.data);
                    cq.add(temp);
                }
                q.remove();
            }
            q = cq;
            cq = new LinkedList<>();
            System.out.println();
        }
        System.out.print(".");
        return;
    }

    private static void levelOrderLineWise(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        System.out.println(q.peek().data);
        while(!q.isEmpty()){
            for(Node temp : q.peek().children){
                sb.append(temp.data+" ");
                q.add(temp);
            }
            if(sb.length()>0){
                System.out.println(sb.toString());
                sb.delete(0, sb.length());
            }
            q.remove();
        }
        System.out.print(".");
        return;
    }

    private static int menu()throws IOException{
        System.out.println("\n1 - Check Size");
        System.out.println("2 - User Trace");
        System.out.println("3 - Max in Tree");
        System.out.println("4 - Heigth of Tree");
        System.out.println("5 - Traversal of Tree");
        System.out.println("6 - Level Order");
        System.out.println("7 - Level Order Line Wise");
        return Input.input_int();
    }

    public static void main(String[] args)throws IOException {
        int n = Input.input_int();
        int[] arr = Input.input_intarr(' ');

        create(arr);
        while(true){
            switch(menu()){
                case 1:
                    Node temp = root;
                    System.out.println("Size of tree :- "+size(temp));
                    break;
                case 2:
                    temp = root;
                    print(temp);
                    break;
                case 3:
                    temp = root;
                    System.out.println("Maximum of tree :- "+max(temp));
                    break;
                case 4:
                    temp = root;
                    System.out.println("Heigth of Tree :- "+height(temp));
                    break;
                case 5:
                    temp = root;
                    traversal(temp);
                    break;
                case 6:
                    temp = root;
                    levelOrder(temp);
                    break;
                case 7:
                    temp = root;
                    levelOrderLineWise(temp);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}


/*
* Input :- 
12
10 20 50 -1 60 -1 -1 30 70 -1 80 11 -1 100 -1 -1 90 -1 40 100
*/