package org.ampov.aoc;

import java.util.Comparator;
import java.util.List;

public class Day1 {
	
	public static void main(String[] args) {
		List<Integer> input = new InputFile("input_d1").getAsIntegers();
		input.sort(Comparator.naturalOrder());
		System.out.println(getProduct(input));
	}
	
	private static int getProduct(List<Integer> input) {
		for (int i = 0; i < input.size(); i++) {
			int n1 = input.get(i);
			for (int j = input.size() - 1; j > i; j--) {
				int n2 = input.get(j);
				int sum = n1 + n2;
				if (sum == 2020) 
					return n1 * n2;
				else if (sum < 2020) 
					break;
			}
		}
		throw new RuntimeException();
	}
}
