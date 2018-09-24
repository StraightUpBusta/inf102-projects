// utility functions
public class Helper implements IHelper {
	@Override
	public boolean isNumber(String str) {
		if (!str.equals("+") && !str.equals("-")
				&& !str.equals("*") && !str.equals("/")) {
			return true;
		}
		return false;
	}
	
	@Override
	public void print(Kattio io, LinkedContainer lc) {
		StringBuilder sb = new StringBuilder();
		recursiveStringBuilder(sb, lc);
		io.print(sb.toString());
	}
	
	// print string
	public void recursiveStringBuilder(StringBuilder sb, LinkedContainer lc) {
		while (lc != null) {
			if (lc.getString() == "(") { // do recursion on left parenthesis
				sb.append(lc.getString());
				recursiveStringBuilder(sb, lc.getSubStr());
			} else {
				sb.append(lc.getString());
			}
			lc = lc.getNext();
		}
	}
}
