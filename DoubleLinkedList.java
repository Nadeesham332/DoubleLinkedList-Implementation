package lk.ac.jfn.eng.ec4070;

/**
 * 
 * This program implements Generic Operations on a Double Linked List
 * 
 * @author Nadeesha Maduranga (nadeesham332@gmail.com)
 * 
 * @param <AnyType>
 * 
 */

public class DoubleLinkedList<AnyType> {
	public static Node H; // H-head
	public static Node T; // T-tail

	// Implementing Double Linked List
	public static class Node<AnyType> {
		AnyType Key;
		Node Next;
		Node Previous;

		public Node(AnyType k) {
			Key = k;
		}

		public AnyType getData() {
			return Key;
		}
	}

	// Implementing Double Linked List
	public DoubleLinkedList(AnyType data) {
		H = new Node(data);
		T = H;
		H.Next = T;
		T.Previous = H;
	}

	/**
	 * Inserting item at the beginning
	 * 
	 * @param data : the value which is inserting
	 */
	public void InsertHead(AnyType data) {
		System.out.println("Insert an item at the beginning : " + data);
		Node newNode = new Node(data);
		newNode.Next = H;
		H.Previous = newNode;
		H = newNode;
	}

	/**
	 * Inserting item at the end
	 * 
	 * @param data : the value which is inserting
	 */
	public void InsertEnd(AnyType data) {
		System.out.println("Insert an item at the end : " + data);
		Node newNode = new Node(data);
		T.Next = newNode;
		newNode.Previous = T;
		T = newNode;
	}

	/**
	 * Removing item from the beginning
	 */
	public void RemoveHead() {
		System.out.println("Remove an item from the beginning");
		H = H.Next;
		// H=temp;
	}

	// Removing item from the end
	public void RemoveEnd() {
		System.out.println("Remove an item from the end");
		Node temp = T;
		T = temp.Previous;
		T.Next = null;
		temp.Previous = null;
	}

	//
	/**
	 * Inserting item before a given node
	 * 
	 * @param Index : Positions of the to insert
	 * @param data  : the value which is inserting
	 */
	public void InsertBeforeNode(int Index, AnyType data) {
		if (Index == 0) {
			InsertHead(data);
		} else {
			System.out.println("Insert an item before a given node : " + Index + " , " + data);
			Node temp = H;
			for (int i = 0; i < Index - 1; i++) {
				temp = temp.Next;
			}
			Node NodeInsert = new Node(data);
			NodeInsert.Next = temp.Next;
			temp.Next.Previous = NodeInsert;
			temp.Next = NodeInsert;
			NodeInsert.Previous = temp;

		}
	}

	/**
	 * Inserting item after a given node
	 * 
	 * @param Index : Positions of the to insert
	 * @param data  : the value which is inserting
	 */
	public void InsertAfterNode(int Index, AnyType data) {
		System.out.println("Insert an item after a given node : " + Index + " , " + data);
		Node temp = H;
		for (int i = 0; i < Index; i++) {
			temp = temp.Next;
		}
		temp = temp.Next;
		Node NodeInsert = new Node(data);
		NodeInsert.Next = temp.Next;
		temp.Next.Previous = NodeInsert;
		NodeInsert.Previous = temp;
		temp.Next = NodeInsert;
	}

	// Removing given node
	public void RemoveNode(int Index) {
		System.out.println("Remove a given node : " + Index);
		Node temp = H;
		for (int i = 0; i < Index - 1; i++) {
			temp = temp.Next;
		}
		if (temp.Next == T) {
			RemoveEnd();
		} else {
			temp.Next = temp.Next.Next;
			temp.Next.Previous = temp;
		}

	}

	/**
	 * Searching index of a value
	 * 
	 * @param k : which wants to search
	 */
	public void SearchValue(AnyType k) {
		System.out.println("Search a value : " + k);
		Node temp = H;
		int n = 0;
		boolean KeyMatch = false;
		while (temp != null) {
			if (temp.Key == k) {
				KeyMatch = true;
				break;
			}
			temp = temp.Next;
			n++;
		}
		if (KeyMatch) {
			System.out.println("\tValue you need to identify is at point " + n);
		} else {
			System.out.println("\tValue you need to identify can not find inside the List");
		}

	}

	/**
	 * Printing Outputs
	 */
	public static void printList() {
		Node temp = H;
		System.out.print("\tLinked List: ");
		while (temp != null) {
			System.out.print(temp.Key);
			System.out.print(',');
			temp = temp.Next;
		}
		System.out.print('\n');
	}

	/**
	 * Implements and prints reversed order
	 */
	public static void printListRevers() {
		Node temp = T;
		System.out.print("Linked Revers : ");

		while (temp != H) {
			System.out.print(temp.Key);
			System.out.print(',');
			temp = temp.Previous;
		}
		System.out.print(temp.Key);
	}

	public static void main(String[] args) {

		DoubleLinkedList<Object> List1 = new DoubleLinkedList(0);
		int[] arr = { 2, 4, 8, 1, 3, 1, 6 };
		for (int i : arr) {
			List1.InsertEnd(i);
		}
		DoubleLinkedList.printList();
		System.out.println();

		List1.InsertHead(8);
		DoubleLinkedList.printList();
		List1.InsertEnd(5);
		DoubleLinkedList.printList();
		List1.RemoveHead();
		DoubleLinkedList.printList();
		List1.RemoveEnd();
		DoubleLinkedList.printList();
		List1.InsertBeforeNode(3, 55);
		DoubleLinkedList.printList();
		List1.InsertAfterNode(5, 100);
		DoubleLinkedList.printList();
		List1.RemoveNode(1);
		DoubleLinkedList.printList();
		List1.SearchValue(55);
		DoubleLinkedList.printListRevers();

	}

}
