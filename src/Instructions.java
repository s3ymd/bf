import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Instructions {
	private Map<Character, String> encodeTable = new HashMap<>();
	private Map<String, Character> decodeTable = new HashMap<>();

	public void define(char bf, String inst) {
		encodeTable.put(bf, inst);
		decodeTable.put(inst, bf);
	}

	public String[] encode(String bf) {
		List<String> list = new ArrayList<>();
		for (char c : bf.toCharArray()) {
			list.add(encodeTable.get(c));
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	public String decode(String... lang) {
		StringBuilder sb = new StringBuilder();
		for (String inst : lang) {
			sb.append(decodeTable.get(inst));
		}
		return sb.toString();
	}
}
