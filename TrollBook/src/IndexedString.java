// custom container to hold int and string
public class IndexedString implements Comparable<IndexedString> {
	private int index;
	private String str;

	public IndexedString(int index, String str) {
		this.index = index;
		this.str = str;
	}
	
	public String getString() {
		return str;
	}
	
	@Override
	public int compareTo(IndexedString o) {
		if (index < o.index) {
			return -1;
		}
		if (index == o.index) {
			return 0;
		}
		return 1;
	}

}
