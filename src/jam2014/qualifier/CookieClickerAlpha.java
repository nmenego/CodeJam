package jam2014.qualifier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nicomartin.enego
 */
public class CookieClickerAlpha {

	private double farmCost = 0;
	private double farmRate = 0;
	private double target = 0;
	private double time = 0;
	private double currentRate = 2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		List<double[]> inputs = new ArrayList<double[]>();
		int cases = in.nextInt();

		for (int i = 0; i < cases; i++) {
			CookieClickerAlpha.saveInput(in, inputs);
		}

		// main logic
		for (int caseNumber = 0; caseNumber < inputs.size(); caseNumber++) {
			double[] input = inputs.get(caseNumber);
			System.out.print("Case #" + (caseNumber + 1) + ": ");

			CookieClickerAlpha game = new CookieClickerAlpha();
			game.solveClicker(input);
		}
	}

	private static void saveInput(Scanner in, List<double[]> inputs) {
		double[] input = new double[3];
		input[0] = in.nextDouble();
		input[1] = in.nextDouble();
		input[2] = in.nextDouble();
		inputs.add(input);
	}

	private void solveClicker(double[] input) {
		farmCost = input[0];
		farmRate = input[1];
		target = input[2];

		// start clicking
		while (true) {
			double timeBuyFarm = buyFarm();
			double timeSkipFarm = skipFarm();
			if (timeBuyFarm > timeSkipFarm) {
				time += timeSkipFarm;
				break;
			} else {
				commit();
			}
		}

		System.out.printf("%.7f", round(time, 7));
		System.out.println("");
	}

	private double buyFarm() {
		double timeNextStep = target / (currentRate + farmRate);
		return (farmCost / currentRate) + timeNextStep;
	}

	private double skipFarm() {
		return target / currentRate;
	}

	private void commit() {
		time += farmCost / currentRate;
		currentRate += farmRate;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
