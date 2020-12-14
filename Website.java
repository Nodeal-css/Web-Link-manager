package manager;
/*
 *  Website class
 * 	   <member variables>
 * 			domain = hold future reference to the domain name of the website.
 * 			link   = hold future reference to the link of the website
 * 			next   = hold future link of the next Website
 * 		
 * 	   <Constructors>
 * 		Website(String, String)
 * 		explicitly added empty constructor
 */
public class Website {
	String domain;
	String link;
	Website next;
	
	public Website(String dom, String lin) {
		this.domain = dom;
		this.link = lin;
		next = null;
	}
	public Website() {}
}
