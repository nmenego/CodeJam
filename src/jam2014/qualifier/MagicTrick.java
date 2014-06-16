package jam2014.qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nicomartin.enego
 */
public class MagicTrick {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		List<int[]> inputs = new ArrayList<int[]>();
		int cases = in.nextInt();

		for (int i = 0; i < cases; i++) {
			MagicTrick.saveInput(in, inputs);
		}

		// main logic
		for (int caseNumber = 0; caseNumber < inputs.size(); caseNumber++) {
			int[] input = inputs.get(caseNumber);
			System.out.print("Case #" + (caseNumber + 1) + ": ");

			MagicTrick trick = new MagicTrick();
			trick.magicTrick(input);
		}
	}

	private static void saveInput(Scanner in, List<int[]> inputs) {
		int[] arr = new int[34]; // 0 an 17 for guesses
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		inputs.add(arr);
	}

	public void magicTrick(int[] input) {
		int[] guesses = new int[4];
		int guess = input[0];
		guesses[0] = input[guess * 4 - 3];
		guesses[1] = input[guess * 4 - 2];
		guesses[2] = input[guess * 4 - 1];
		guesses[3] = input[guess * 4 - 0];

		int guess2 = input[17];

		// get hitCount
		int hitCount = 0;
		int hitNum = -1;
		for(int count = 0; count < 4; count++) {
			int num = checkVsExisting(guesses, input[guess2 * 4 + 14 + count]);
			if (num != -1) {
				hitCount++;
				hitNum = num;
			}
		}

		if (hitCount == 1) {
			System.out.println(hitNum);
		} else if (hitCount > 1) {
			System.out.println("Bad magician!");
		} else {
			System.out.println("Volunteer cheated!");
		}
	}

	public int checkVsExisting(int[] existing, int val) {
		for (int str : existing) {
			if (str == val) {
				return val;
			}
		}
		return -1;
	}
}
