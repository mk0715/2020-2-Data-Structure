import java.util.*;

// Name :
// Student ID :

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {
	class TreeNode <U extends KeyValue> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;
	BST() { 
		// BST constructor. 
		root = null;
	}

	void Show() {
		System.out.print( "PRE  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("IN   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("POST Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Number of Nodes : ");
		System.out.println( Count(root));
		System.out.print("HEIGHT : ");
		System.out.println( Height(root));
		System.out.println("");
	}

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			// 트리가 비어있으면
			root = new TreeNode<T>(item);

			return true;
		}

		TreeNode<T> ptr, parent;
		
		parent = null;
		ptr = root;
		boolean fromLeft = true;
		
		while(true) {
			
			int cond =  compare(item.GetKey(), ptr.data.GetKey()); //키 값 비교
			
			if (cond == -1) {
				// 삽입하려는 키가 작으면
				if(ptr.leftChild == null) {
					
					ptr.leftChild = new TreeNode<T>(item);
					
					return true;

				}
				
				fromLeft = true;
				parent = ptr;
				ptr = ptr.leftChild;
				
			}else if (cond ==1) {
				// 삽입하려는 키가 크다면
				if(ptr.rightChild == null) {
					
					ptr.rightChild = new TreeNode<T>(item);
					
					return true;
				}
				
				fromLeft = false;
				parent = ptr;
				ptr = ptr.rightChild;
				
			}else {
				// 키가 중복이라면
				return false;
			}
		}
	}
	

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;
		
		while(true) {
			
			if(ptr == null) {
				
				return null;
			}
			
			int cond =  compare(item.GetKey(), ptr.data.GetKey());
			
			if (cond == -1) {

				ptr = ptr.leftChild;
				
			}else if (cond ==1) {
				
				ptr = ptr.rightChild;
				
			}else {
				
				return ptr.data;
				
				}
			}
	} 


	boolean Delete(T item)  {
		if(root == null) {
			
			return false; // non existing key
						
		}
		
		TreeNode<T> ptr = root;
		TreeNode<T> parent = null;
		
		boolean fromLeft = true;
		
		// 삭제할 노드 찾기
		while(true) {
			
			if(ptr == null) {
				// 값 없음
				return false;
			}
			
			int cond =  compare(item.GetKey(), ptr.data.GetKey());
			
			if (cond == -1) {
				
				parent = ptr;
				ptr = ptr.leftChild;
				fromLeft = true;
				
			}else if (cond ==1) {
				
				parent = ptr;
				ptr = ptr.rightChild;
				fromLeft = false;
				
			}else {
				
				break;
				
				}
			}
		
		// degree 0, 1 
		

		if(ptr.leftChild == null) {
			
			if(ptr == root) {
				
				root = ptr.rightChild;
				// 루트 노드를 삭제할 때
				
			}else {
				
				if(fromLeft == true) {
					
					parent.leftChild = ptr.rightChild;
					
				}else {
					
					parent.rightChild = ptr.rightChild;
				}
			}
			
			
		}else if (ptr.rightChild == null) {
			
			// 오른쪽 노드가 없을 때
			
			if(ptr == root) {
				// 루트 노드를 삭제할 때
				
				root = ptr.leftChild;
				
			}else {
				
				if(fromLeft == true) {
					
					parent.leftChild = ptr.leftChild;
				
				}else {
					
					parent.rightChild = ptr.leftChild;
					// 오른쪽에 자식이 없음
				
				}
			}
			
			
		}else {
			
			parent = ptr;
			TreeNode<T> sub = ptr.leftChild; // 왼쪽으로 이동, 서브트리의 최댓값
			fromLeft = false;
			
			while(sub.rightChild != null) {
				
				parent = sub;
				sub = sub.rightChild;
				fromLeft = true;
			}
			
			ptr.data = sub.data;
			
			if(fromLeft == true) {
				
				if(sub.leftChild != null) {
					
					// 제일 큰 값(좌측 서브트리)이 좌측자식 노드를 가지고 있으면
					parent.rightChild = sub.leftChild;
					
				}else {
					
				parent.rightChild = sub.rightChild; 
				
				}
				
			}else {
				
				parent.leftChild = sub.leftChild;
			}
			
			
		}
		
		return true;
	}

	void  PreOrder(TreeNode<T> t)  {
		
		if (t == null) {
			
			return;
		}
		
		System.out.print("["+Integer.toString(t.data.GetKey())+'(' + t.data.GetValue()+")"+"]");
		PreOrder(t.leftChild);
		PreOrder(t.rightChild);

	}

	void  InOrder(TreeNode<T> t)  {

		if (t == null) {
			
			return;
		}
		
		InOrder(t.leftChild);
		System.out.print("["+Integer.toString(t.data.GetKey())+'(' + t.data.GetValue()+")"+"]");
		InOrder(t.rightChild);

	}

	void  PostOrder(TreeNode<T> t)  {

		
		if (t == null) {
			
			return;
		}
		
		PostOrder(t.leftChild);
		PostOrder(t.rightChild);
		System.out.print("["+Integer.toString(t.data.GetKey())+'(' + t.data.GetValue()+")"+"]");

	}

	int  Count(TreeNode<T> t)  {

		if(t == null) {
			
			return 0;
			
		}else {
			
			return Count(t.leftChild) + Count(t.rightChild) + 1;
		}
	}
	int  Height(TreeNode<T> t)  {
		
		if(t == null) {
			return 0;
			
		}else {
			
			int left_height = Height(t.leftChild);
			int right_height = Height(t.rightChild);
			
			int height = 0;
			if(left_height > right_height) {
				
				height = left_height + 1;
				
			}else {
				
				height = right_height + 1;
			}
			
			return height;
		}

	}
	
	int compare(int key1, int key2) {
		// 키값 비교
		
		if(key1 > key2) {
			
			return 1;
			
		}else if(key1 < key2) {
			
			return -1;
			
		}else {
			
			return 0;
		}
	}
	
	
}

