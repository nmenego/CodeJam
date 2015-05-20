package jam2013.qualifier;

import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/2270488/dashboard
 * 
 * @author nicomartin.enego
 */
public class TicTacToeTomek {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			String[][] arr = new String[4][4];
			int cases = in.nextInt();

			for (int i = 0; i < cases; i++) {

				int xCount = 0;
				int oCount = 0;
				boolean isFull = true;
				// get input
				// rows
				for (int j = 0; j < 4; j++) {
					String rowStr = in.next();
					// cols
					for (int k = 0; k < 4; k++) {
						String c = String.valueOf(rowStr.charAt(k));
						if (c.equals("X"))
							xCount++;
						if (c.equals("O"))
							oCount++;
						if (c.equals("."))
							isFull = false;
						arr[j][k] = c;
					}
				}

				// solution and results..
				System.out.print(String.format("Case #%s: ", i + 1));
				if (xCount == oCount) {
					if (hasWon("O", arr)) {
						System.out.println("O won");
						continue;
					}
				} else {
					if (hasWon("X", arr)) {
						System.out.println("X won");
						continue;
					}
				}

				if (isFull) {
					System.out.println("Draw");
				} else {
					System.out.println("Game has not completed");
				}
			}
		} finally {
			in.close();
		}
	}

	private static boolean hasWon(String check, String[][] arr) {

		// check horizontal
		for (int i = 0; i < 4; i++) {
			int score = 0;
			for (int j = 0; j < 4; j++) {
				String s = arr[i][j];
				if (check.equals(s) || "T".equals(s)) {
					score++;
				}
			}
			if (score == 4) {
				return true;
			}
		}

		// check vertical
		for (int j = 0; j < 4; j++) {
			int score = 0;
			for (int i = 0; i < 4; i++) {
				String s = arr[i][j];
				if (check.equals(s) || "T".equals(s)) {
					score++;
				}
			}
			if (score == 4) {
				return true;
			}
		}

		// check right-diagonal
		{
			int score = 0;
			for (int i = 0, j = 0; i < 4 && j < 4; i++, j++) {
				String s = arr[i][j];
				if (check.equals(s) || "T".equals(s)) {
					score++;
				}
			}

			if (score == 4) {
				return true;
			}
		}

		// check left-diagonal
		{
			int score = 0;
			for (int i = 0, j = 3; i < 4 && j >= 0; i++, j--) {
				String s = arr[i][j];
				if (check.equals(s) || "T".equals(s)) {
					score++;
				}
			}
			if (score == 4) {
				return true;
			}
		}

		return false;
	}
}
