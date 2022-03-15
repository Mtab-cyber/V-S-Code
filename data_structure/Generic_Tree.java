package data_structure;
import java.io.*;
import java.util.*;
public class Generic_Tree {

    private static Node root = null;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){

        }

        Node(int data){
            this.data = data;
        }
    }

    private static class Pair{
        int x;
        int y;

        Pair(){

        }

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
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

    private static void levelOrderLineWise(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            System.out.print(q.peek().data+" ");
            for(Node temp : q.peek().children){
                cq.add(temp);
            }
            q.poll();
            if(q.isEmpty()){
                q = cq;
                cq = new LinkedList<>();
                System.out.println();
            }
        }
        return;
    }

    private static void levelOrderLineWise3(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(new Node(-1));
        while(!q.isEmpty()){
            System.out.print(q.peek().data+" ");
            for(Node temp : q.peek().children){
                q.add(temp);
            }
            q.poll();
            if(q.peek().data == -1){
                System.out.println();
                q.add(new Node(-1));
            }
        }
        return;
    }

    private static void levelOrder(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.print(q.peek().data);
        while(!q.isEmpty()){
            for(Node temp : q.peek().children){
                System.out.print(" "+temp.data);
                q.add(temp);
            }
            
            q.remove();
        }
        System.out.print(".");
        return;
    }

    private static void levelOrderLineWiseZigZag(Node root) {
        if(root == null){
            return;
        }
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(root);
        int level = 0;
        while(!ms.isEmpty()){
            System.out.print(ms.peek().data+" ");
            if(level%2 == 0){
                for(Node temp : ms.peek().children){
                    cs.push(temp);
                }
            }
            else{
                for(int i = ms.peek().children.size()-1; i >= 0; i--){
                    cs.push(ms.peek().children.get(i));
                }
            }
            ms.pop();
            if(ms.isEmpty()){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
        return;
    }

    private static Node mirror(Node root){
        if(root == null){
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            for(Node temp : q.peek().children){
                q.add(temp);
            }
            Collections.reverse(q.peek().children);
            q.poll();
        }
        return root;
    }

    private static Node removeLeaves(Node root){
        if(root == null){
            return root;
        }
        for(int i = root.children.size()-1; i >= 0; i--){
            if(root.children.get(i).children.size() == 0){
                root.children.remove(root.children.get(i));
            }
        }

        for(Node temp : root.children){
            removeLeaves(temp);
        }

        return root;
    }

    private static int menu()throws IOException{
        System.out.println("\n1 - Check Size");
        System.out.println("2 - User Trace");
        System.out.println("3 - Max in Tree");
        System.out.println("4 - Heigth of Tree");
        System.out.println("5 - Traversal of Tree");
        System.out.println("6 - Level Order");
        System.out.println("7 - Level Order Line Wise");
        System.out.println("8 - Level Order Line Wise ZigZag");
        System.out.println("9 - Mirror the Tree");
        System.out.println("10 - Remove Leaves");
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
                case 8:
                    temp = root;
                    levelOrderLineWiseZigZag(temp);
                    break;
                case 9:
                    temp = root;
                    temp = mirror(temp);
                    levelOrderLineWise(temp);
                    break;
                case 10:
                    temp = root;
                    temp = removeLeaves(temp);
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