package org.ampov.aoc;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import org.ampov.aoc.puzzle.*;

public class AdventOfCode {
	
	public static void main(String[] args) {
		new AdventOfCode().printSolutions();
	}
	
	private Set<AbstractPuzzle> puzzles = new LinkedHashSet<>(LocalDate.now().getDayOfMonth());
	
	public AdventOfCode() {
		puzzles.add(new Day1());
		puzzles.add(new Day2());
		puzzles.add(new Day3());
	}
	
	private void printSolutions() {
		puzzles
			.stream()
			.forEach(System.out::println);
	}

}
