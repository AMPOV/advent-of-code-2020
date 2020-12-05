package org.ampov.aoc.puzzle;

import java.util.Arrays;
import java.util.Comparator;

public class Puzzle5 extends AbstractPuzzle {
	
	public Puzzle5() {
		solutionPart1 = Arrays.stream(inputFile
				.getContent()
				.replaceAll("[FL]", "0")
				.replaceAll("[BR]", "1")
				.split("\n"))
			.map(s -> 
				Byte.parseByte(s.substring(0, 7), 2) * 8 + 
				Byte.parseByte(s.substring(7, 10), 2))
			.max(Comparator.naturalOrder());
	}
}
