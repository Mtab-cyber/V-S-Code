
import java.util.Scanner;
public class bst{
	
	public static class Node{
		Node left, right;
		int data;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Node root;
	 public bst() {
		 root = null;
	 }
	 
	 public static void insert(int data) {
		 Node node = new Node(data);
		 if(root == null) {
			 root = node;
			 return;
		 }
		 Node temp = root;
		 while(true) {
			 if(temp.data >= data) {
				 if(temp.left == null) {
					 temp.left = node;
					 return;
				 }
				 else {
					 temp = temp.left;
				 }
			 }
			 else {
				 if(temp.right == null) {
					temp.right = node; 
					return;
				 }
				 else {
					 temp = temp.right;
				 }
			 }
		 }
	 }
	 
	 public static Node minval(Node temp) {
		 while(temp.left != null) {
			 temp = temp.left;
		 }
		 return temp;
	 }
	 
	 public static Node delete(int data, Node temp) {
		 if(root == null) {
			 return null;
		 }
		 if(data < temp.data) {
			 temp.left = delete(data, temp.left);
		 }
		 else if(data > temp.data) {
			 temp.right = delete(data, temp.right);
		 }
		 else {
			 if(temp.left == null && temp.right == null) {
				 temp = null;
			 }
			 else if(temp.right == null) {
				 temp = temp.left;
			 }
			 else if(temp.left == null) {
				 temp = temp.right;
			 }
			 else {
				 Node min = minval(temp.right);
				 temp.data = min.data;
				 temp.right = delete(min.data, temp.right);
			 }
		 }
		 return temp;
	 }
	 
	 public static void inorder(Node temp) {
		 if(root == null) {
			 System.out.println("Tree is empty");
			 return;
		 }
		 else if(temp.left != null) {
			 temp = temp.left;
		 }
		 System.out.print(temp.data + " ");
		 if(temp.right != null) {
			 temp = temp.right;
		 }
	 }
	 
	 public static void main(String[] args) {
		System.out.println("\tMenu");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Press\tfor\n  1\tInsertion\n  2\tDeletion\n  3\tInorder Traversal\n  4\t2D Representation\n  5\tExit");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the numbers to insert and enter -1 to stop");
				while(true) {
					int n = scan.nextInt();
					if(n==-1)
						break;
					insert(n);
				}
				break;
			case 2:
				System.out.println("Enter the number to delete : ");
				int n = scan.nextInt();
				delete(n,root);
				inorder(root);
				break;
			case 3:
				System.out.println("Traversal : ");
				inorder(root);
				break;
			case 4:
				break;
			case 5:
				System.exit(0);
				break;
			default :
				System.out.println("Wrong input ");
			}
		}
	}
}