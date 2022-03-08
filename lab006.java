// Lab 007	: Disjoint Sets
// Name :
// Student ID :

import java.util.*;


class DisjointSets {
	int numofelements;  // the total number of elements in all the disjoint sets
	private int[] parent; // maintains the parent pointer of each element in the disjoint sets
	private int[] weight; // maintains the weight of each set


	DisjointSets() { 
		// DisjointSets constructor. 
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
	    // Show the array elements in parent[]

		str = "parent[]: - ";
		for(int i = 1; i <= numofelements; i++)
			str += parent[i] + " ";
		return str;
	}

	void InitSet(int n) { 
		// Initialize the array parent[] and weight[]
		numofelements = n;
		parent = new int[n+1];
		weight = new int[n+1];

		for (int i=1; i<=n; i++){
			parent[i] = 0;
			weight[i] = 0;
		}
	}

	boolean Union(int i, int j) { 
	// Union the set that contains i and the set that contains j
	// the set that has larger weight is the new root of the unioned set
	// when the weights are the same, choose the root of smaller value

		// first find the root of i and j
		int root1 = SimpleFind(i);
		int root2 = SimpleFind(j);

		int weight1 = weight[root1];
		weight[root1]++;
		int weight2 = weight[root2];
		weight[root2]++;
		
		if (root1 == root2) {
			return false;
		} else {

			if (weight1 > weight2) {
				weight[root1] += weight[root2];
				parent[root2] = root1;
			} else if (weight1 < weight2) { 
				weight[root2] += weight[root1];
				parent[root1] = root2;
			} else if (weight1 == weight2) {
				if (root1 > root2){
					weight[root1] += weight[root2];
					parent[root2] = root1;
				} else if (root1 < root2) {
					weight[root2] += weight[root1];
					parent[root1] = root2;
				}
			}
		return true;
		}
	}

	int SimpleFind(int i) { 
	// return the root node that contains the element i
		int root = i;
		while (parent[root] > 0)
			root = parent[root]; // move up the tree	
		return root;
	}
}

