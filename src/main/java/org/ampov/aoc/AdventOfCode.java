package org.ampov.aoc;

import java.util.HashSet;
import java.util.Set;

import org.ampov.aoc.puzzle.AbstractPuzzle;
import org.ampov.aoc.puzzle.Day1;
import org.ampov.aoc.puzzle.Day2;

public class AdventOfCode {
	
	public static void main(String[] args) {
		new AdventOfCode().printSolutions();
	}
	
	private Set<AbstractPuzzle> puzzles = new HashSet<>(24);
	
	public AdventOfCode() {
		puzzles.add(new Day1());
		puzzles.add(new Day2());
	}
	
	private void printSolutions() {
		puzzles
			.stream()
			.forEach(System.out::println);
	}
}
