package aws.prog;

import java.util.Scanner;

/**
 * Longest substring with 2 characters
 * 
 * @author nicomartin.enego
 *
 */
public class ProgCon18 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tries = in.nextInt();
		for (int count = 0; count < tries; count++) {
			String inputz = in.next();
			doGame(inputz);
		}
	}

	public static void doGame(String text) {
		String answer = null;
		int sIdx = 0, eIdx = text.length();
		char a = '\u0000', b = '\u0000';
		int count = 1;
		a = text.charAt(0);
		for (int ptr = count; ptr < text.length(); ptr++) {
			// aa
			if (text.charAt(ptr) == a) {
				// proceed to next.
				eIdx = ptr;
			}

			else if (b == '\u0000' || (b != '\u0000' && b == text.charAt(ptr))) {
				if (b == '\u0000') {
					b = text.charAt(ptr);
				}
				// ab
				eIdx = ptr;
			}

			else {
				String tempAnswer = text.substring(sIdx, eIdx + 1);

				if (answer != null && !answer.equals(text)) {
					// compare new
					if (tempAnswer.length() > answer.length()) {
						answer = tempAnswer;
					}
				} else {
					answer = tempAnswer;
				}

				count++;
				ptr = count;
				// reset a and b
				a = text.charAt(ptr);
				b = '\u0000';
				sIdx = ptr;
				eIdx = text.length();
			}
		}

		String tempAnswer2 = text.substring(sIdx, eIdx + 1);

		if (answer == null) {
			System.out.println(tempAnswer2);
		} else {
			if (tempAnswer2.length() >= answer.length()) {
				answer = tempAnswer2;
			}
			System.out.println(answer);
		}
	}

}
