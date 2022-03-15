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
        Node curr;

        Pair(){

        }

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        Pair(Node curr, int x){
            this.curr = curr;
            this.x = x;
        }
    }

    public static class GenericTree implements Iterable<Integer>{

        Node root;

        public GenericTree(Node root){
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreOrderIterator(root);
            return obj;
        }
    }

    public static class GTPreOrderIterator implements Iterator<Integer>{

        Integer nval;
        Stack<Pair> stk;

        public GTPreOrderIterator(Node root){
            stk = new Stack<>();
            stk.push(new Pair(root,-1));
            next();
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            if(nval != null){
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            Integer fr = nval;
            nval = null;
            while(!stk.isEmpty()){
                Pair top = stk.peek();
                if(top.x == -1){
                    nval = top.curr.data;
                    top.x++;
                    break;
                }
                else if(top.x == top.curr.children.size()){
                    stk.pop();
                }
                else{
                    stk.push(new Pair(top.curr.children.get(top.x),-1));
                    top.x++;
                }
            }
            return fr;
        }
        
    }

    private static int size;
    private static int min;
    private static int max;
    private static int height;
    private static Node predecessor;
    private static Node successor;
    private static int state;
    private static int ciel;
    private static int floor;
    private static int maxsumnode;
    private static int maxsum;
    private static int dia;

    private static Node create(int[] arr) {
        Stack<Node> stk = new Stack<>();
        for(int i : arr){
            if(i == -1){
                if(stk.isEmpty()){
                    System.out.println("Unhandled Exception");
                    return null;
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
        return root;
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

    private static Node linearize(Node root){
        if(root.children.size() == 0){
            return root;
        }

        Node res = linearize(root.children.get(root.children.size() - 1));

        while(root.children.size() > 1){
            Node lst = root.children.remove(root.children.size() - 1);
            Node slst = root.children.get(root.children.size() - 1);
            Node lslst = linearize(slst);
            lslst.children.add(lst);
        }

        return res;
    }

    private static boolean find(Node root, int k){
        if(root.data == k){
            return true;
        }
        for(Node temp : root.children){
            boolean ans = find(temp,k);
            if(ans)
                return ans;
        }
        return false;
    }
    
    private static ArrayList<Integer> findPathtoRoot(Node root, int k){
        if(root.data == k){
            ArrayList<Integer> arr = new ArrayList<>();
            return arr;
        }

        for(Node temp : root.children){
            ArrayList<Integer> arr = findPathtoRoot(temp,k);
            if(arr.size() > 0){
                arr.add(temp.data);
                return arr;
            }
        }

        return new ArrayList<>();
    }

    private static int lca(Node root, int a, int b){
        ArrayList<Integer> atr = findPathtoRoot(root,a);
        ArrayList<Integer> btr = findPathtoRoot(root,b);
        int i = atr.size() - 1;
        int j = btr.size() - 1;

        while(i >= 0 && j >= 0 && atr.get(i) == btr.get(j)){
            i--;
            j--;
        }

        return (int)atr.get(++j);
    }

    private static int distNode(Node root, int a, int b){
        ArrayList<Integer> atr = findPathtoRoot(root,a);
        ArrayList<Integer> btr = findPathtoRoot(root,b);
        int i = atr.size() - 1;
        int j = btr.size() - 1;

        while(i >= 0 && j >= 0 && atr.get(i) == btr.get(j)){
            i--;
            j--;
        }

        return (++i + ++j);
    }

    private static boolean checkSimilar(Node root1, Node root2){
        if(root1.children.size() == root2.children.size()){
            for(int i = 0; i < root1.children.size(); i++){
                boolean temp = checkSimilar(root1.children.get(i),root2.children.get(i));
                if(temp == false){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    private static ArrayList<Integer> getChildrenData(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        for(Node temp : root.children){
            arr.add(temp.data);
        }
        return arr;
    }

    private static boolean isMirror(Node root1, Node root2){
        if(root1.children.size() != root2.children.size()){
            return false;
        }
        for(int i = 0; i < root1.children.size(); i++){
            ArrayList<Integer> arr1 = getChildrenData(root1.children.get(i));
            ArrayList<Integer> arr2 = getChildrenData(root2.children.get(root2.children.size() - 1 - i));
            Collections.reverse(arr2);
            if(!arr1.equals(arr2)){
                return false;
            }
            else{
                boolean temp = isMirror(root1.children.get(i),root2.children.get(root2.children.size() - 1 - i));
                if(!temp){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isMirrorWithoutData(Node root1, Node root2){
        if(root1.children.size() != root2.children.size()){
            return false;
        }

        for(int i = 0; i < root1.children.size(); i++){
            if(!isMirrorWithoutData(root1.children.get(i),root2.children.get(root1.children.size() - 1 - i))){
                return false;
            }
        }

        return true;
    }

    private static boolean isSymmetric(Node root) {
        return isMirrorWithoutData(root,root);
    }

    private static void multiSolver(Node root,int ht){
        if(root == null){
            return;
        }
        size++;
        max = Math.max(max,root.data);
        min = Math.min(min,root.data);
        height = Math.max(height,ht);
        for(Node temp : root.children){
            multiSolver(temp,ht+1);
        }
    }

    private static void getPredecessor_Successor(Node root, int data) {
        if(state == 0){
            if(root.data == data){
                state = 1;
            }
            else{
                predecessor = root;
            }
        }
        else if(state == 1){
            successor = root;
            state = 2;
            return;
        }

        for(Node temp : root.children){
            getPredecessor_Successor(temp,data);
        }
    }

    private static void getCielandFloor(Node root, int data){
        if(root.data < data){
            floor = Math.min(floor,root.data);
        }
        if(root.data > data){
            ciel = Math.min(ciel, root.data);
        }

        for(Node temp : root.children){
            getCielandFloor(temp,data);
        }
    }

    private static void getKthLargest(Node root,int k){
        int factor = Integer.MIN_VALUE;
        while(k-->0){
            getCielandFloor(root,factor);
            factor = floor;
            floor = Integer.MAX_VALUE;
        }
    }

    private static void itr_postOrder(Node root) {
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root,-1));
        while(stk.isEmpty() == false){
            if(stk.peek().x == -1){
                stk.peek().x++;
            }
            else if(stk.peek().x < stk.peek().curr.children.size()){
                stk.peek().x++;
                stk.push(new Pair(stk.peek().curr.children.get(stk.peek().x - 1),-1));
            }
            else{
                System.out.println(stk.peek().curr.data);
                stk.pop();
            }
        }
    }

    private static void itr_preOrder(Node root) {
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root,-1));
        while(stk.isEmpty() == false){
            if(stk.peek().x == -1){
                System.out.println(stk.peek().curr.data);
                stk.peek().x++;
            }
            else if(stk.peek().x < stk.peek().curr.children.size()){
                stk.peek().x++;
                stk.push(new Pair(stk.peek().curr.children.get(stk.peek().x - 1),-1));
            }
            else{
                stk.pop();
            }
        }
    }

    private static int getDiaOfTree(Node root) {
        /*
        *My Approach
        int ht = 0;
        int ht2 = 0;
        Node maxht = null;
        for(Node temp : root.children){
            int tempht = ht;
            ht = Math.max(ht, height(temp));
            if(ht != tempht){
                maxht = temp;
            }
        }
        for(Node temp : root.children){
            if(temp != maxht){
                ht2 = Math.max(ht2, height(temp));
            }
        }
        return ht+ht2+2;
        */

        int dch = -1;
        int sdch = -1;

        for(Node temp : root.children){
            int ch = getDiaOfTree(temp);
            if(ch > dch){
                sdch = dch;
                dch = ch;
            }
            else if(ch > sdch){
                sdch = ch;
            }
        }

        if(sdch + dch + 2 > dia){
            dia = sdch + dch + 2;
        }
        dch += 1;

        return dch;
    }

    private static int getNodeWithMaxSumSubTree(Node root) {
        int sum = 0;
        for(Node temp : root.children){
            int csum = getNodeWithMaxSumSubTree(temp);
            sum += csum;
        }
        sum += root.data;
        maxsum = Math.max(maxsum,sum);
        if(maxsum == sum)maxsumnode = root.data;
        return sum;
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
        System.out.println("11 - Linearize the Tree");
        System.out.println("12 - Find an Element");
        System.out.println("13 - Find path to root");
        System.out.println("14 - Lowest Common Ancestor");
        System.out.println("15 - Distance between edges");
        System.out.println("16 - Check is both Trees are Similar");
        System.out.println("17 - Check if the tree is a Mirror of orignal");
        System.out.println("18 - Check if the tree is Symmetric");
        System.out.println("19 - MultiSolver");
        System.out.println("20 - Get Predecessor and Successor");
        System.out.println("21 - Get Ciel and Floor");
        System.out.println("22 - Get Kth Largest Element");
        System.out.println("23 - Node with maximum sum of subtree");
        System.out.println("24 - Diameter of the Generic Tree");
        System.out.println("25 - Iterative Pre-Order and Post-Order");
        System.out.println("26 - Iterable tree");
        return Input.input_int();
    }

    public static void main(String[] args)throws IOException {
        int[] arr = Input.input_intarr(" ");

        create(arr);
        while(true){
            switch(menu()){
                case 0:
                    System.exit(0);
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
                case 11:
                    temp = root;
                    linearize(temp);
                    levelOrder(temp);
                    break;
                case 12:
                    temp = root;
                    System.out.println(find(temp,Input.input_int()));
                    break;
                case 13:
                    temp = root;
                    System.out.println(findPathtoRoot(temp,Input.input_int()));
                    break;
                case 14:
                    temp = root;
                    System.out.println(lca(temp,Input.input_int(),Input.input_int()));
                    break;
                case 15:
                    temp = root;
                    System.out.println(distNode(temp,Input.input_int(),Input.input_int()));
                    break;
                case 16:
                    temp = root;
                    System.out.println("Enter the other array for second tree : ");
                    Node temp2 = create(Input.input_intarr(" "));   
                    System.out.println(checkSimilar(temp,temp2)?"Both tree are Similar":"They are not similar to each other");   
                    break;          
                case 17:
                    temp = root;
                    System.out.println("Enter the other array for second tree : ");
                    temp2 = create(Input.input_intarr(" "));   
                    System.out.println(isMirror(temp,temp2)?"Both tree are Mirror of each other":"They are not Mirror of each other");   
                    break;
                case 18:
                    temp = root;
                    System.out.println(isSymmetric(temp)?"The tree is Symmetric":"The tree is not Symmetric");
                    break;
                case 19:
                    temp = root;
                    size = 0;
                    height = 0;
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    multiSolver(temp,0);
                    System.out.println("Min Element : "+min+"\nMax Element : "+max+"\nHeight of Tree : "+height+"\nSize of Tree : "+size);
                    break; 
                case 20:
                    temp = root;
                    state = 0;
                    predecessor = null;
                    successor = null;
                    getPredecessor_Successor(temp,Input.input_int());
                    System.out.println("Predecessor : "+predecessor+"\nSuccessor : "+successor);
                    break;
                case 21:
                    temp = root;
                    ciel = Integer.MIN_VALUE;
                    floor = Integer.MAX_VALUE;
                    getCielandFloor(temp,Input.input_int()); 
                    System.out.println("Ciel :- "+ciel+"\nFloor :- "+floor);
                    break; 
                case 22:
                    temp = root;
                    floor = Integer.MAX_VALUE;
                    getKthLargest(temp,Input.input_int());
                    System.out.println("Kth largest Element : "+floor);
                    break;
                case 23:
                    temp = root;
                    maxsumnode = 0;
                    maxsum = Integer.MIN_VALUE;
                    getNodeWithMaxSumSubTree(temp);
                    System.out.println("Node with maximum sum node of subtree : "+maxsumnode);
                    break;
                case 24:
                    temp = root;
                    System.out.println("Diameter of the Generic Tree : "+getDiaOfTree(temp));
                    break;
                case 25:
                    temp = root;
                    itr_preOrder(temp);
                    itr_postOrder(temp);
                    break;
                case 26:
                    temp = root;
                    GenericTree gti = new GenericTree(temp);
                    for(int i : gti){
                        System.out.print(i+" ");
                    }
                    break;
                default:
                    continue;
            }
        }
    }
}
/*
* Input :- 
12
10 20 50 -1 60 -1 -1 30 70 -1 80 11 -1 100 -1 -1 90 -1 40 100
mirror : - 10 30 40 100 -1 -1 90 -1 80 100 -1 11 -1 -1 70 -1 -1 20 60 -1 50
*/