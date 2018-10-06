import java.util.ArrayList;
import java.util.Collections;

public class TrollBook {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int lines = io.getInt();
		SortableLinkedList<IndexedString> li = new SortableLinkedList<>();
		for (int i = 0; i < lines; i++) {
			String str = io.getWord();
			li.add(new IndexedString(io.getInt(), str));
		}
		li.sort();
		print(li, io);
		io.close();
	}	
	
	public static void print(SortableLinkedList<IndexedString> li, Kattio io) {
		StringBuilder sb = new StringBuilder();
		for (IndexedString s : li) {
			sb.append(s.getString());
			sb.append(" ");
		}
		io.print(sb.toString());
	}
}

