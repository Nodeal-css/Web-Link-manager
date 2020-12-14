package manager;
/*
 * MainDriver class
 *   <member methods>
 *   	* sticker(LinkedList, LinkedList)
 * 			- This method will merge 2 linkedList 
 * 			  so that "Option#1" will not add a Node in the middle
 * 			  of list1 and list2.
 * 
 * 		* main(String [] args)
 * 			  LinkedList list1 = stack list of websites. If method prev() is invoked, 
 * 								 the last element is passed 
 * 								 to the list2's queue so that prev() method can be used
 * 				  				 continuously for earlier previous websites.
 * 			  LinkedList list2 = queue list of websites. if the queue contains the elements
 * 								 from list1's stack after using prev() method, the queue
 * 							     will serve as a list of "next" websites. 
 * 								 "Option#6"-->"next" will print the first element of the queue
 * 								 and passes it to the list1's stack (reverse of option#2).
 * 					
 * 		     Option 1:  Add website
 *                             - user can enter a new website and will be added next to the last element
 *                               of the list. 
 *                             - If "list2" is not null, sticker(LinkedList, LinkeList) method will
 *                               merge the two list so that the newly added Node 
 *                               will be addressed after list1 and list2, not in the middle of lists.
 *                             
 * 			 Option 2:  Go back to previous website
 * 							   - the prev() method will print out the 2nd to the last element of "list1".
 * 								 In order to continuously decrement earlier elements/websites,
 * 								 we need to remove the last element of "list1" and the discarded
 * 								 website will be passed to "list2" for later Option#6's function.
 * 
 * 			 Option 3:  Display History
 * 							   - will invoke the display() method of LinkedList class.
 * 
 * 			 Option 4:  Get total sites
 * 							   - will invoke the length() method of LinkedList class.
 * 
 * 			 Option 5:  Display current site
 * 							   - The current site will be updated after->
 * 										* using Option# 2 
 * 						Notice:		    * using Option# 6
 * 										* adding a new website
 * 							   - The last Node of "list1" is the current website and will change
 * 								 depends on the addition or deletion of "list1".
 * 
 *           Option 6:  Forward to next site
 *           				   - the first element of "list2" is the next website of the current website from
 *           					 "list1". After printing the next Website, it will be passed
 *           					 to "list1" stack so that the "next website" will be updated as the current site.
 *           				     The "list2" queue first element will be deleted after the process.
 *           				   - if the queue is empty, it will not execute the process.
 *           Option 7:  Exit
 * 							   - Exit the web browser link manager
 */
import java.util.Scanner;
public class MainDriver {
	static Scanner obj = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option = 0;
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		//list2.addLast("Google", "google.com");
		//list2.addLast("Pinterest", "pinterest.com");
		do {
			System.out.println("\nOptions:\n1. Add website\n2. Go back to previous site ");
			System.out.println("3. Display browsing history\n4. Get total websites\n5. Display current site ");
			System.out.print("6. Forward to next site\n7. Exit\nEnter option: ");
			option = obj.nextInt();
			obj.nextLine();
				switch(option) {
					case 1:
						String dom, lin;
						System.out.println("\n------------\nAdd website\n------------");
						System.out.print("Enter Domain name: ");
						dom = obj.nextLine();
						System.out.print("Enter Link: ");
						lin = obj.nextLine();
						list1 = sticker(list1, list2);
						list1.addLast(dom, lin);
						System.out.println("Succesfully added");
						break;
					case 2:
						if(list1.length() <= 1) {
							System.out.println("No previous websites");
						}else {
							list1.prev();
							list2.addFirst(list1.getLastDom(), list1.getLastLin());
							list1.removeLast();
						}
						break;
					case 3:
						if(list1.length() < 1 && list2.length() < 1) {
							System.out.println("\nEmpty History");
						}else {
							System.out.println("\n------------------\nBrowsing history\n------------------");
							list1.display();
							list2.display();
						}
						
						break;
					case 4:
						System.out.println("\n-----------------\nTotal websites: " + (list1.length() + list2.length())+ "\n-----------------");
						
						break;
					case 5:
						if(list1.length() < 1) {
							System.out.println("\n-----------------\nCurrent website\n" + " --> None" + "\n-----------------");
						}else {
							System.out.println("\n-----------------\nCurrent website\n" + list1.getLastDom() + " --> " + list1.getLastLin() + "\n-----------------");
						}
						break;
					case 6:
						if(list2.length() < 1) {
							System.out.println("\nNo more next website");
						}else {
							System.out.println("\n-----------------\nNext website:\n" + list2.getFirstDom() + " --> " + list2.getFirstLin() + "\n-----------------");
							list1.addLast(list2.getFirstDom(), list2.getFirstLin());
							list2.removeFirst();
						}
						break;
					case 7:
						break;
					default:
						System.out.println("\ninvalid option");
				}
		}while(option != 7);
	}

	public static LinkedList sticker(LinkedList list1, LinkedList list2) {
		int temp = list2.length();
		for(int i = 0; i < temp; i++) {
			list1.addLast(list2.getFirstDom(), list2.getFirstLin());
			list2.removeFirst();
		}
		return list1;
	}
}
