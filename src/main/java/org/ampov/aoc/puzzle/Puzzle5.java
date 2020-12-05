package org.ampov.aoc.puzzle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Puzzle5 extends AbstractPuzzle {
	
	private List<String> input = Arrays.asList(inputFile
			.getContent()
			.replaceAll("[FL]", "0")
			.replaceAll("[BR]", "1")
			.split("\n"));
	
	public Puzzle5() {
		solutionPart1 = input
			.stream()
			.map(seat -> 
					Byte.parseByte(seat.substring(0, 7), 2) * 8 + 
					Byte.parseByte(seat.substring(7, 10), 2))
			.max(Comparator.naturalOrder());
	}
}
