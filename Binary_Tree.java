
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
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

    static class Pair{
        Node node;
        int st;
        Pair(Node node, int st){
            this.node = node;
            this.st = st;
        }
    }

    //Creating an Iterable tree with overriding the inbuilt methods using Iteratot and Iterable class

    public static class BT implements Iterable<Integer> {
        private Node root;
        public BT(Node root){
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator(){
            Iterator<Integer> obj = new BTIterable(root);
            return obj;
        }
    }

    public static class BTIterable implements Iterator<Integer>{
        Stack<Pair> stk;
        Integer val;

        BTIterable(Node root){
            stk = new Stack<>();
            stk.push(new Pair(root,-1));
            next();
        }

        @Override
        public boolean hasNext(){
            if(val == null)
                return false;
            return true;
        }

        @Override
        public Integer next(){
            Integer cur = val;
            val = null;
            while(stk.size() > 0){
                Pair curr = stk.peek();
                if(curr.st == -1){
                    val = curr.node.data;
                    curr.st++;
                    break;
                }
                else if(curr.st == 0){
                    curr.st++;
                    if(curr.node.left!=null){
                        stk.push(new Pair(curr.node.left, -1));
                    }
                }
                else if(curr.st == 1){
                    curr.st++;
                    if(curr.node.right != null){
                        stk.push(new Pair(curr.node.right,-1));
                    }
                }
                else{
                    stk.pop();
                }
            }
            return cur;
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

    private static ArrayList<Node> getNodePathtoRoot(Node root, int data){
        if(root.data == data){
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(root);
            return arr;
        }
        if(root.left != null){
            ArrayList<Node> arr = getNodePathtoRoot(root.left,data);
            if(arr.size() > 0){
                arr.add(root);
                return arr;
            }
        }
        if(root.right != null){
            ArrayList<Node> arr = getNodePathtoRoot(root.right,data);
            if(arr.size() > 0){
                arr.add(root);
                return arr;
            }
        }
        return new ArrayList<>();
    }

    private static void printKlevelDown(Node root, int k){
        Queue<Node> mq = new LinkedList<>();
        Queue<Node> cq = new LinkedList<>();
        mq.add(root);
        int lev = 1;
        while(mq.size() > 0 && lev <= k){
            Node temp = mq.poll();
            if(lev == k){
                System.out.print(temp.data+" ");
            }
            if(temp.left != null){
                cq.add(temp.left);
            }
            if(temp.right != null){
                cq.add(temp.right);
            }
            if(mq.isEmpty()){
                mq = cq;
                cq = new LinkedList<>();
                lev++;
            }
        }
    }

    private static void printKlevelFar(Node root, int data, int k){
        ArrayList<Node> path = getNodePathtoRoot(root, data);
        path.add(root);
        for(Node temp : path){
            System.out.println(temp.data+"dtaa");
            printKlevelDown(temp, k);
            k--;
            if(k == 0){
                break;
            }
        }
    }

    private static void printPathinRange(Node root, String path, int low, int high, int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(sum+root.data <= high && sum+root.data >= low){
                System.out.println(path+" "+root.data);
            }
            return;
        }
        printPathinRange(root.left,path+" "+root.data, low, high, sum+root.data);
        printPathinRange(root.right,path+" "+root.data, low, high, sum+root.data);
    }

    private static Node getLeftClonedTree(Node root){
        if(root == null){
            return null;
        }

        Node ndl = getLeftClonedTree(root.left);
        Node ndr = getLeftClonedTree(root.right);
        Node temp = new Node(root.data);
        temp.left = ndl;
        temp.right = null;
        root.left = temp;
        root.right = ndr;


        return root;
    }

    private static Node getBacktoOrignal(Node root){
        if(root == null){
            return null;
        }

        Node lnn = getBacktoOrignal(root.left.left);
        Node rnn = getBacktoOrignal(root.right);

        root.left = lnn;
        root.right = rnn;

        return root;
    }

    private static void printSingleChildNode(Node root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right != null){
            System.out.print(root.data+" ");
            printSingleChildNode(root.right);
        }
        else if(root.left != null && root.right == null){
            System.out.print(root.data+" ");
            printSingleChildNode(root.left);
        }
        else{
            printSingleChildNode(root.left);
            printSingleChildNode(root.right);
        }
    }

    private static Node getRemoveLeaves(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return null;
        }
        Node lft = getRemoveLeaves(root.left);
        Node rgt = getRemoveLeaves(root.right);
        root.left = lft;
        root.right = rgt;

        return root;
    }

    private static int getDiameter(Node root){
        if(root == null){
            return 0;
        }
        int ld = getDiameter(root.left);
        int rd = getDiameter(root.right);
        int f = getHeight(root.left) + getHeight(root.right) + 2;

        return Math.max(f, Math.max(ld, rd));
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
        System.out.println("11 - Iterable tree");
        System.out.println("12 - Print K level down");
        System.out.println("13 - Print K far element");
        System.out.println("14 - Print path of sum in Range");
        System.out.println("15 - Print left cloned tree");
        System.out.println("16 - Get back to the orignal tree");
        System.out.println("17 - Print single child node");
        System.out.println("18 - Remove Leaves of the Tree");
        System.out.println("19 - Diameter of Tree");
        return Integer.parseInt(br.readLine());
    }

    private static Integer[] testCase(){
        Integer[] arr = {10,20,40,null,50,80,null,null,null,30,60,null,70};
        return arr;
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Integer[] arr = testCase();//Input.input_Intarr(" ");
        
        Node ans = null;
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
                    int n = Integer.parseInt(br.readLine());
                    ArrayList<Integer> path = getPathtoRoot(temp,n);
                    for(int i : path){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    break;
                case 11:
                    temp = root;
                    BT bt = new BT(temp);
                    for(int i : bt){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    break;
                case 12:
                    temp = root;
                    int a = Integer.parseInt(br.readLine());
                    printKlevelDown(temp,a);
                    System.out.println();
                    break;
                case 13:
                    temp = root;
                    a = Integer.parseInt(br.readLine());
                    int b = Integer.parseInt(br.readLine());
                    printKlevelFar(temp, a, b);
                    System.out.println();
                    break;
                case 14:
                    temp = root;
                    a = Integer.parseInt(br.readLine());
                    b = Integer.parseInt(br.readLine());
                    printPathinRange(temp,"",a,b,0);
                    break;
                case 15:
                    temp = root;
                    ans = getLeftClonedTree(temp);
                    bt = new BT(ans);
                    for(int i : bt){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    break;
                case 16:
                    System.out.println("Frist run the 15 case");
                    ans = getBacktoOrignal(ans);
                    bt = new BT(ans);
                    for(int i : bt){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    break;
                case 17:
                    temp = root;
                    printSingleChildNode(temp);
                    break;
                case 18:
                    temp = root;
                    ans = getRemoveLeaves(temp);
                    getLevelOrder(ans);
                    System.out.println();
                    break;
                case 19:
                    temp = root;
                    int dia = getDiameter(temp);
                    System.out.println(dia);
                    break;
                default:
                    continue;
            }
        }
    }
}