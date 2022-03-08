// Lab 009	: Graph Floyd Algorithm 
// Name :
// Student ID :

import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Adjacency matrix
	private int[] dist; // dist array
	private int[] p; // p array

	final int LargeCost = 999999;

	Graph() { 
		// Graph constructor. 
		numofnodes = 0;
	}


	void Init(int n) { 
		numofnodes = n;
		// now create 2 dimensional array of numofnodes * numofnodes
		CostAdj = new int[numofnodes][numofnodes];
		dist = new int[numofnodes];
		p = new int[numofnodes];

		for(int i = 0; i < numofnodes; i++) {
			// initialize all entries to 0
			for(int j = 0; j < numofnodes; j++)
				CostAdj[i][j] = LargeCost;  // initialize the adjacency matrix
			CostAdj[i][i] = 0;
		}
	}
	public String toString() { 
		String str;
		int i = 0;
		str = "Dist : ";
		for(i = 0; i < numofnodes; i++)
			str +=  dist[i] + " ";
		str += "\n";
	
		str += "P    : ";
		for( i = 0; i < numofnodes; i++)
			str += p[i] + " ";
		str += "\n";
	
		// show the paths to all the destinations
		for( i = 0; i < numofnodes; i++) {
			str += "Path => " + i + " : ";
			str += OutPath(i);	
			str += "\n";
		}
		return str;
	}



	void Edge(int v1, int v2, int cost) { 
		
		CostAdj[v1][v2] = cost;
	}

	void BellmanFord(int v) { 
		for (int i=1; i<numofnodes; i++) {
		    dist[i] = LargeCost;
		}
		p[v] = -1;
		dist[v] = 0;
		for (int k=1; k<numofnodes; k++){
			for (int i=0; i<numofnodes; i++) {
		   		for (int j=0; j<numofnodes; j++) {
		        			if (dist[j] > dist[i] + CostAdj[i][j]) {
						dist[j] = dist[i] + CostAdj[i][j];
						p[j] = i;
		        			}
		   		}
			}
		}
	}

	String OutPath(int i) { 
		String str = "";

		// NEED TO IMPLEMENT
		if (p[i] == -1) {
			str = str + i;
		}
		else {
			str = str + OutPath(p[i]) + " " + i;
		}

		return str;
	}


}




