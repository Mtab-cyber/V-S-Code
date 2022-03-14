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

    private static int menu()throws IOException{
        System.out.println("\n1 - Check Size");
        System.out.println("2 - User Trace");
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
                    System.out.println(size(temp));
                    break;
                case 2:
                    temp = root;
                    print(temp);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
