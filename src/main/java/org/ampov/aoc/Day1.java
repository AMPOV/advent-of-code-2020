package org.ampov.aoc;

import java.util.Comparator;
import java.util.List;

public class Day1 {
	
	public static void main(String[] args) {
		List<Integer> input = new InputFile("input_d1").getAsIntegers();
		input.sort(Comparator.naturalOrder());
		System.out.println("Part1: " + getProduct(input, 0));
		System.out.println("Part2: " + getProduct(input.subList(1, input.size()), input.get(0)));
	}
	
	private static int getProduct(List<Integer> input, int factorStart) {
		int factor1 = input.get(0);
		for (int i = input.size() - 1; i > 0; i--) {
			int factor2 = input.get(i);
			int sum = factorStart + factor1 + factor2;
			if (sum == 2020) {
				if (factorStart == 0)
					return factor1 * factor2;
				else 
					return factorStart * factor1 * factor2; 
			}
			else if (sum < 2020) 
				break;
		}
		return getProduct(input.subList(1, input.size()), factor1);
	}
}
