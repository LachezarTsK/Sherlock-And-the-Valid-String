import java.util.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		String inputString = reader.next();
		String result = isValid(inputString);
		System.out.println(result);
	}

	static String isValid(String inputString) {

		TreeMap<Integer, Integer> uniqueNumberPerChar = new TreeMap<Integer, Integer>();

		for (char i = 'a'; i <= 'z'; i++) {
			if (inputString.contains(Character.toString(i))) {

				int index = (int) i - (int) 'a';
				String regex = "[a-z&&[^" + i + "]]";
				int totalChars = inputString.replaceAll(regex, "").length();
				String charToString = Character.toString(i);

				if (!uniqueNumberPerChar.keySet().contains(totalChars)) {
					uniqueNumberPerChar.put(totalChars, totalChars);
				} else {
					int newValue_totalChars = uniqueNumberPerChar.get(totalChars) + totalChars;
					uniqueNumberPerChar.put(totalChars, newValue_totalChars);
				}
			}
		}

		if (uniqueNumberPerChar.size() > 2) {
			return "NO";
		}

		else if (uniqueNumberPerChar.size() == 2) {
			if (Math.abs(uniqueNumberPerChar.firstKey() - uniqueNumberPerChar.lastKey()) == 1) {
				if ((uniqueNumberPerChar.get(uniqueNumberPerChar.firstKey()) / uniqueNumberPerChar.firstKey() != 1
						&& uniqueNumberPerChar.get(uniqueNumberPerChar.lastKey()) / uniqueNumberPerChar.lastKey() != 1)
						&& Math.abs(uniqueNumberPerChar.get(uniqueNumberPerChar.firstKey())
								- uniqueNumberPerChar.get(uniqueNumberPerChar.lastKey())) > 1) {
					return "NO";
				}
			} else {

				if (uniqueNumberPerChar.containsKey(1) && uniqueNumberPerChar.containsValue(1)) {
					return "YES";
				}

				if (uniqueNumberPerChar.get(uniqueNumberPerChar.firstKey()) / uniqueNumberPerChar.firstKey() != 1
						|| uniqueNumberPerChar.get(uniqueNumberPerChar.lastKey())
								/ uniqueNumberPerChar.lastKey() != 1) {
					return "NO";
				}
				return "NO";
			}
		}
		return "YES";
	}
}
