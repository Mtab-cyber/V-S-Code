package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Linked_List {
	
	public static Scanner scan = new Scanner(System.in);
	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	static class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	static Node head;
	
	public static void insert(int data) {
		Node insert_node = new Node(data);
		insert_node.next = null;
		
		if(head == null) {
			head.next = insert_node;
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = insert_node;
		}
	}
	
	public static void delete(int data) {
		Node temp = head;
		if(temp == null) {
			System.out.println("No node found");
			return;
		}
		while(temp.next.data != data) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return;
	}
	
	public static void traverse() {
		System.out.print("Your linked list : ");
		Node temp = head;
		while(temp.next!=null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println(temp.data);
		return;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("  Welcome to Linked List");
		while(true) {
			System.out.println("\tMenu\nPress\t\tFor\n1\t\tInsertsion\n2\t\tDeletion\n3\t\tTraversing\n0\t\tExit");
			int choice = scan.nextInt();
			switch(choice) {
			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter the elements to : ");
				String[] str = bf.readLine().split(" ");
				for(String data : str) {
					insert(Integer.parseInt(data));
				}
				traverse();
				break;
			case 2:
				traverse();
				System.out.println("Enter the element to delete : ");
				int data = scan.nextInt();
				delete(data);
				traverse();
				break;
			case 3:
				traverse();
				break;
			default :
				System.out.println("Enter the write option ");
			}
		}
	}
}
