
import java.util.*;
import java.lang.*;
import java.io.*;

class MST_Prims {
	public static int size;
	int minKey(int key[], Boolean mstSet[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < size; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}
	void printMST(int parent[], int graph[][])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < size; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	void primMST(int graph[][])
	{
		int parent[] = new int[size];

		int key[] = new int[size];
		Boolean mstSet[] = new Boolean[size];
		for (int i = 0; i < size; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0; 
		parent[0] = -1; 
		for (int count = 0; count < size - 1; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;

			for (int v = 0; v < size; v++)

				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		printMST(parent, graph);
	}

	public static void main(String[] args)
	{
		MST_Prims t = new MST_Prims();
		System.out.println("Enter the number of vertices :- ");
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		
		System.out.println("Enter the adjacency matrix :- ");
		
		int graph[][] = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				graph[i][j] = scan.nextInt();
			}
		}
		t.primMST(graph);
		scan.close();
	}
}
