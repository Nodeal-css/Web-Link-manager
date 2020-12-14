package manager;
/*
 *  LinkedList class
 * 	(contains methods of linkedList data structure)
 * 
 *  <member variable/s>
 * 		* head = contains the address of the first 
 * 				 element of the linkedList. (singly LinkedList)
 * 
 *  <member methods>
 *  	* createWeb(String, String)
 *  			- creates and returns a new object/Node.
 *  	* addLast(String, String) 
 *  			- traversing to each elements until it reaches to the end, then
 *  			  assign the the last node's next to the new Node.
 *  	* addFirst(String, String)
 *  		    - Inserting a new Node to the address of the first element in 
 *  			  the list which is "head"
 *  	* removeFirst()
 *  			- Removes the first element by assigning the "head" to "head.next"
 *  			  and the address of the removed element will be assigned to null.
 *  	* removeLast()
 *  			- Removes the last element of the list by traversing to reach the end
 *  			  then assign it's 2nd to the last element "Node.next" to null.
 *  	* display()
 *  			- using the address of the first element we want to traverse until it
 *  			  reaches to null. While node is not null, prints out the domain and link
 *  			  of the current node then traverse to the next elements.	    
 *  	* length()
 *              - The number of elements in the list will determine the iterations,
 *                then the number of total iterations will be returned.
 *  	* prev()
 *  		    - traverse to reach the end using two reference variables "temp" and "prev"
 *  			  "prev" reference variable will always be the previous element of 
 *  		      whatever "temp" holds. then print out the domain and link that 
 *  		      "prev" contains after traversing.
 *  	* getLastDom()
 *  	* getLastLin()
 *  			- returns the domain String object from the last element in the list.
 *  			- returns the link String object of the last element in the list.
 *  	* getFirstDom()		
 *  	* getFirstLin()						
 *  			- returns the domain String object from the address of "head".
 *  		    - returns the link String object from the first Node in the list.
 */			
public class LinkedList {
	private Website head;
	
	private Website createWeb(String domain, String link) {
		return new Website(domain, link);
	}
	
	public void addLast(String dom, String lin) {		
		Website input = createWeb(dom, lin);
		if(head == null) {
			head = input;
		}else {
			Website temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = input;
		}
	}
	
	public void addFirst(String dom, String lin) {		
		Website input = createWeb(dom, lin);
		if(head == null) {
			head = input;
		}else {
			input.next = head;
			head = input;
		}
	}
	
	public void removeFirst() {							
		if(head == null) {
			return;
		}else {
			Website temp = head;
			head = head.next;
			temp.next = null;
		}
	}
	
	public void removeLast() {							
		if(head == null) {
			return;
		}else {
			Website temp = head;
			while(temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	
	public void display() {								
		if(head == null) {
			return;
		}else {
			Website temp = head;
			
			while(temp != null) {
				System.out.println(" " + temp.domain + " --> " + temp.link);
				temp = temp.next;
				
			}
		}
	}	
	
	public int length() {								
		int len = 0;
		Website temp = head;
			while(temp != null) {
			temp = temp.next;
			len++;
			}
		return len;
	}
	
	public void prev() {								
		if(head == null) {
			return;
		}else {
			Website temp = head;
			Website prev = null;
			while(temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			System.out.println("----------------\nPrevious site"); 
			System.out.println(prev.domain + " --> " + prev.link);
			System.out.println("----------------");
		}
	}
	
	public String getLastDom() {
		Website temp = head;
		if(head == null) {
			return "";
		}else {
			
			while(temp.next != null) {
				temp = temp.next;
			}
		}
		return temp.domain;
	}													
	public String getLastLin() {
		Website temp = head;
		if(head == null) {
			return "";
		}else {
			while(temp.next != null) {
				temp = temp.next;
			}
		}
		return temp.link;
	}
	
	public String getFirstDom() {
		Website temp = head;
		if(head == null) {
			return "";
		}else {
			return temp.domain;
		}
	}													
	public String getFirstLin() {
		Website temp = head;
		if(head == null) {
			return "";
		}else {
			return temp.link;
		}
	}
}

















