import java.util.*;

/**
 * Generic version of the SortedList class.
 */

class SortedList <T extends Comparable<T> > {

	class SortedListNode <U extends Comparable<U> >{
	    U data; // storage for data
		SortedListNode<U> link;    // link to the next node
	};

	private SortedListNode<T> first; // pointer to the dummy header node
	private SortedListNode<T> av; // pointer to the available list

	public SortedList() {
		av = null;
		first = null;
	}

	void Init(T data) { // SortedList constructor. Create a dummy first node
		first = GetNode();
		first.data = data;
		first.link = first;
	}


	void Clear() {	// Delete the circular list
	//	cerr << "NEED TO IMPLEMENT" << endl;
		SortedListNode<T> x = first.link;
		first.link = av;
		av = x;

	}

	SortedListNode<T> GetNode() {	// Provide a node for use
	//	cerr << "NEED TO IMPLEMENT" << endl;
		if(av==null){
           		return new SortedListNode<>();
        	}
        	else{
            		SortedListNode<T> x = av;
          		av = av.link;
          		return x;
        	}

	}

	void  Insert(T e) {	// insert the element into the list
	// We first need to find the position to insert
		
	//	cerr << "NEED TO IMPLEMENT" << endl;
		SortedListNode<T> x = GetNode();
       		x.data = e;

       		SortedListNode<T> p = first;

		while (p.link.data.compareTo(x.data)>0) {
			p = p.link;				
		}
		if(x.data == p.data){
			x.link = first;
		}
		      
		if(p.link == first) {
			p.link = x;
			x.link = first;
			x.data = e;
		}
		else {
			x.link = p.link;
			x.data = e;
			p.link = x;
		}
	}


	public String toString() {
		String str = "";

		if(first == null) return "";
		SortedListNode<T> p = first.link;

		str += "List : ";
		// traverse all the nodes
		while (p != first) {
			str += p.data + "  ";
			p = p.link;
		}
		str += "\n";

		p = av;
		// show the count of av list
		int cnt = 0;
		while (p != null) {
			cnt++;
			p = p.link;
		}
		str +=  "Av : " + cnt;

		return str;
	}
}; 


