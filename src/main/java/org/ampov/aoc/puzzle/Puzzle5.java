package org.ampov.aoc.puzzle;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Puzzle5 extends AbstractPuzzle {
	
	private SortedSet<Integer> seats = Arrays.stream(inputFile
			.getContent()
			.replaceAll("[FL]", "0")
			.replaceAll("[BR]", "1")
			.split("\n"))
		.map(s -> 
			Byte.parseByte(s.substring(0, 7), 2) * 8 + 
			Byte.parseByte(s.substring(7, 10), 2))
		.collect(Collectors.toCollection(TreeSet::new));
	
	public Puzzle5() {
		solutionPart1 = seats.last();
		solutionPart2 = IntStream.range(seats.first(), seats.last())
				.boxed()
				.filter(i -> !seats.contains(i))
				.collect(Collectors.toCollection(TreeSet::new))
				.first();
	}
}
