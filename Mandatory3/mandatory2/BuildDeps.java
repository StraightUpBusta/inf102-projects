package no.uib.ii.inf102.f18.mandatory2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BuildDeps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str); 
		BDDigraph G = new BDDigraph(n);
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			String[] files = parseLine(str);
			if (files.length == 1) continue;
			for (int j = 1; j < files.length; j++) {
				G.addEdge(files[j], files[0]);
			}
		}
		String source = br.readLine();
		BDDepthFirstSearch dfs = new BDDepthFirstSearch(G, source);
		Map<String, Integer> postVal = dfs.post();
		// this is madness, would pursue sorting further, but running out of time before exams
		Map<Integer, String> postValInv = new HashMap<>(); // invert key-value relationship
		for (Map.Entry<String, Integer> entry : postVal.entrySet()) { // copy contents 
		    postValInv.put(entry.getValue(), entry.getKey());
		}
		postValInv = new TreeMap(postValInv); // sort by key
		Map<Integer, String> rev = new TreeMap(Collections.reverseOrder()); // reverse it
		rev.putAll(postValInv); // copy contents 
		// end of madness
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry : rev.entrySet()) {
			sb.append(entry.getValue() + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	public static String[] parseLine(String line) {
		String[] ret = line.split(" ");
		ret[0] = ret[0].substring(0, ret[0].length() - 1);
		return ret;
	}
}
