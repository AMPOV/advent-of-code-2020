package org.ampov.aoc.puzzle;

import java.util.Comparator;
import java.util.List;

public class Day1 extends AbstractPuzzle {
	
	public Day1() {
		List<Integer> input = inputFile.getAsIntegers();
		input.sort(Comparator.naturalOrder());
		solutionPart1 = getProduct(input, 0);
		solutionPart2 = getProduct(input.subList(1, input.size()), input.get(0));
	}
	
	private int getProduct(List<Integer> input, int factorStart) {
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
