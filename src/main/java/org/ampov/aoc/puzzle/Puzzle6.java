package org.ampov.aoc.puzzle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Puzzle6 extends AbstractPuzzle {
	
	public Puzzle6() {
		solutionPart1 = getSum(s -> s.replaceAll("[^a-z]", "")
				.chars()
				.distinct()
				.count());
		solutionPart2 = getSum(s -> {
			Set<Integer> allChars = IntStream.rangeClosed('a', 'z').boxed().collect(Collectors.toCollection(HashSet::new));
			Arrays.stream(s.split("\n")).forEach(line -> allChars.retainAll(line.chars().boxed().collect(Collectors.toSet())));
			return allChars.size();
		});
	}
	
	private long getSum(ToLongFunction<String> function) {
		return Arrays.stream(inputFile.getContent().split("\n\n"))
				.mapToLong(function)
				.sum();
	}
}
