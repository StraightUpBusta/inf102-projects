public class RevPolishToInfix {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		LinkedStack<LinkedContainer> li = new LinkedStack<>(); // my custom class
		Helper helper = new Helper(); // utility functions in own class
		while (io.hasMoreTokens()) {
			String str = io.getWord();
			if (helper.isNumber(str)) {
				li.push(new LinkedContainer(str));
			} else {
				// construct string and push it
				LinkedContainer expr2 = li.pop();
				LinkedContainer expr1 = li.pop();
				LinkedContainer oper = new LinkedContainer(str);
				li.push(new LinkedContainer(expr1, oper, expr2));
			}
		}
		helper.print(io, li.pop());
		io.close();
	}
}
