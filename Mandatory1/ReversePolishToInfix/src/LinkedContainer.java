// linkable string container
public class LinkedContainer implements ILinkedContainer {
	private String str; 
	private LinkedContainer subStr; // use subStr instead of next to create tree-like structure
	private LinkedContainer next;
	
	public LinkedContainer(String str) {
		this.str = str;
	}

	public LinkedContainer(LinkedContainer expr1, LinkedContainer oper, LinkedContainer expr2) {
		// construct mathematical expression
		LinkedContainer lp = new LinkedContainer("(");
		LinkedContainer rp = new LinkedContainer(")");
		str = "(";
		subStr = expr1; // use subStr instead of next to create tree-like structure
		expr1.next = oper;
		oper.next = expr2;
		expr2.next = rp;
	}
	
	@Override
	public String getString() {
		return str;
	}
	
	@Override
	public LinkedContainer getSubStr() {
		return subStr;
	}
	
	@Override
	public LinkedContainer getNext() {
		return next;
	}
}
